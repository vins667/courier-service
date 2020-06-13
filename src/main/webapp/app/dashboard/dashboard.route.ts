import { Routes } from '@angular/router';
import { DashboardComponent } from 'app/dashboard/dashboard.component';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
export const DASHBOARD_ROUTE: Routes = [
    {
        path: 'dashboard',
        component: DashboardComponent,
        data: {
            authorities: ['ROLE_USER', 'ROLE_ADMIN'],
            pageTitle: 'Dashboard'
        },
        canActivate: [UserRouteAccessService]
    }
];
