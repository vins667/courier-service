import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router, ActivatedRouteSnapshot, NavigationEnd, NavigationError } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import {CommonService} from "app/common.service";

@Component({
  selector: 'jhi-main',
  templateUrl: './main.component.html'
 // styleUrls: ['main.scss']
})
export class MainComponent implements OnInit {
  commonService?: any;
  pageTitle?: string;
  constructor(private accountService: AccountService, private titleService: Title, private router: Router, private cs: CommonService) {this.commonService = cs;}

  ngOnInit(): void {
    // try to log in automatically
    this.accountService.identity().subscribe();

    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.updateTitle();
        this.cs.navbarToggleValue = false;
        this.cs.sidebarToggleValue = true;
      }
      if (event instanceof NavigationError && event.error.status === 404) {
        this.router.navigate(['/404']);
      }
    });
  }

  private getPageTitle(routeSnapshot: ActivatedRouteSnapshot): string {
    let title: string = routeSnapshot.data && routeSnapshot.data['pageTitle'] ? routeSnapshot.data['pageTitle'] : '';
    if (routeSnapshot.firstChild) {
      title = this.getPageTitle(routeSnapshot.firstChild) || title;
    }
    return title;
  }

  private updateTitle(): void {
    this.pageTitle = this.getPageTitle(this.router.routerState.snapshot.root);
    if (!this.pageTitle) {
      this.pageTitle = 'Courierservice';
    }
    this.titleService.setTitle(this.pageTitle);
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }
}
