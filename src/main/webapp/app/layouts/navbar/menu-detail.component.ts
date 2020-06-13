import { Component, OnInit } from '@angular/core';
import { Account } from 'app/core/user/account.model';
import { AccountService } from 'app/core/auth/account.service';
import { User } from 'app/core/user/user.model';

@Component({
    selector: 'jhi-menu-details',
    templateUrl: './menu-detail.component.html'
})
export class MenuDetailComponent implements OnInit {
    inProduction?: boolean;
    user?: User;
    sidebarItems: any;
    swaggerEnabled?: boolean;
    isNavbarCollapsed?: boolean;
    account?: Account;

    constructor(private accountService: AccountService) {}

    ngOnInit():void {
        this.sidebarItems = [
            {
                link: 'dashboard',
                label: 'Dashboard',
                icon: 'tachometer-alt',
                type: ['ROLE_ADMIN', 'ROLE_USER', 'ROLE_VENADM']
            },
            {
                link: 'profile',
                label: 'Profile',
                icon: 'user',
                type: ['ROLE_VENADM']
            },
            {
                link: 'admin/user-management',
                label: 'Users',
                icon: 'users',
                type: ['ROLE_ADMIN', 'ROLE_VENADM']
            },
            {
                label: 'Masters',
                icon: 'tasks',
                isCollapsed: false,
                type: ['ROLE_ADMIN', 'ROLE_USER'],
                subItem: [{ link: 'zone-master', label: 'Zone', icon: 'zn' }]
            }
        ];
    }

    collapseMenu(item:any):void {
        if (item.isCollapsed === true) {
            item.isCollapsed = false;
        } else {
            item.isCollapsed = true;
        }
    }

    collapseNavbar():void {
        this.isNavbarCollapsed = true;
    }
}
