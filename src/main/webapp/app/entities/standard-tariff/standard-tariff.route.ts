import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IStandardTariff, StandardTariff } from 'app/shared/model/standard-tariff.model';
import { StandardTariffService } from './standard-tariff.service';
import { StandardTariffComponent } from './standard-tariff.component';
import { StandardTariffDetailComponent } from './standard-tariff-detail.component';
import { StandardTariffUpdateComponent } from './standard-tariff-update.component';

@Injectable({ providedIn: 'root' })
export class StandardTariffResolve implements Resolve<IStandardTariff> {
  constructor(private service: StandardTariffService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IStandardTariff> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((standardTariff: HttpResponse<StandardTariff>) => {
          if (standardTariff.body) {
            return of(standardTariff.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new StandardTariff());
  }
}

export const standardTariffRoute: Routes = [
  {
    path: '',
    component: StandardTariffComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'StandardTariffs',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: StandardTariffDetailComponent,
    resolve: {
      standardTariff: StandardTariffResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StandardTariffs',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: StandardTariffUpdateComponent,
    resolve: {
      standardTariff: StandardTariffResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StandardTariffs',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: StandardTariffUpdateComponent,
    resolve: {
      standardTariff: StandardTariffResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'StandardTariffs',
    },
    canActivate: [UserRouteAccessService],
  },
];
