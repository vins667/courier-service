import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IStateMaster, StateMaster } from 'app/shared/model/state-master.model';
import { StateMasterService } from './state-master.service';
import { StateMasterComponent } from './state-master.component';
import { StateMasterDetailComponent } from './state-master-detail.component';
import { StateMasterUpdateComponent } from './state-master-update.component';

@Injectable({ providedIn: 'root' })
export class StateMasterResolve implements Resolve<IStateMaster> {
  constructor(private service: StateMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IStateMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((stateMaster: HttpResponse<StateMaster>) => {
          if (stateMaster.body) {
            return of(stateMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new StateMaster());
  }
}

export const stateMasterRoute: Routes = [
  {
    path: '',
    component: StateMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'StateMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: StateMasterDetailComponent,
    resolve: {
      stateMaster: StateMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StateMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: StateMasterUpdateComponent,
    resolve: {
      stateMaster: StateMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StateMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: StateMasterUpdateComponent,
    resolve: {
      stateMaster: StateMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StateMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
