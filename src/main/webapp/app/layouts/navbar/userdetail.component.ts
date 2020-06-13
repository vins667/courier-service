import { Component, OnInit } from '@angular/core';
import { Account } from 'app/core/user/account.model';
import { AccountService } from 'app/core/auth/account.service';

@Component({
    selector: 'jhi-user-name-details',
    templateUrl: './userdetail.component.html'
})
export class UserDetailComponent implements OnInit {
    account: Account | null=null;

    constructor(private accountService: AccountService) {}

    ngOnInit():void{
        this.accountService.identity().subscribe(account =>{
            this.account =account;
        });
    }
}
