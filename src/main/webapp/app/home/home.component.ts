import { Component, ViewChild, ElementRef, OnInit, AfterViewInit, OnDestroy} from '@angular/core';
import { LoginService } from 'app/core/login/login.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Account } from 'app/core/user/account.model';
import { AccountService } from 'app/core/auth/account.service';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { StateStorageService } from 'app/core/auth/state-storage.service';
import { SnotifyPosition, SnotifyToastConfig } from 'ng-snotify';
export const toastConfig: SnotifyToastConfig = {
  bodyMaxLength: 500,
  titleMaxLength: 200,
  backdrop: -1,
  position: SnotifyPosition.centerTop,
  timeout: 3000,
  showProgressBar: false,
  closeOnClick: true,
  pauseOnHover: false
};
@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss'],
})
export class HomeComponent implements OnInit, AfterViewInit, OnDestroy{
  account: Account | null = null;
  authSubscription?: Subscription;
  @ViewChild('username', { static: false })
  username?: ElementRef;
  authenticationError = false;
  loginForm = this.fb.group({
    username: [''],
    password: [''],
    rememberMe: [false]
  });

  constructor(
    private loginService: LoginService,
    private stateStorageService: StateStorageService,
    private router: Router,
    private accountService: AccountService,
    private fb: FormBuilder,
    private eventManager: JhiEventManager
  ) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
  }
 
  ngAfterViewInit(): void {
    if (this.username) {
      this.username.nativeElement.invokeElementMethod(this.username.nativeElement, 'focus', []);
    }
  }

  login(): void {
    this.loginService
      .login({
        username: this.loginForm.get('username')!.value,
        password: this.loginForm.get('password')!.value,
        rememberMe: this.loginForm.get('rememberMe')!.value
      })
      .subscribe(
        () => {
          this.authenticationError = false;
          this.eventManager.broadcast({
            name: 'authenticationSuccess',
            content: 'Sending Authentication Success'
          });
          // previousState was set in the authExpiredInterceptor before being redirected to login modal.
          // since login is successful, go to stored previousState and clear previousState
          this.stateStorageService.storeUrl('dashboard');
          const redirect = this.stateStorageService.getUrl();
          if (redirect) {
            this.router.navigate(['dashboard']);
          }
        },
        () => (this.authenticationError = true)
      );
  }
  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.eventManager.destroy(this.authSubscription);
      this.authSubscription.unsubscribe();
    }
  }
}
