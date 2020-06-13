import {Component, OnDestroy, OnInit} from '@angular/core';
import {AccountService} from 'app/core/auth/account.service';
import {Account} from 'app/core/user/account.model';
import {Subscription} from 'rxjs';
import {JhiEventManager} from 'ng-jhipster';

@Component({
  selector: 'jhi-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  authSubscription?: Subscription;
  constructor(private accountService: AccountService,
              private eventManager: JhiEventManager) {
  }

  ngOnInit(): void {
    // try to log in automatically
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
  }

  ngOnDestroy(): void {
    if(this.authSubscription) {
      this.eventManager.destroy(this.authSubscription);
      this.authSubscription.unsubscribe();
    }
  }
}
