import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICityMaster, CityMaster } from 'app/shared/model/city-master.model';
import { CityMasterService } from './city-master.service';
import { CityMasterComponent } from './city-master.component';
import { CityMasterDetailComponent } from './city-master-detail.component';
import { CityMasterUpdateComponent } from './city-master-update.component';

@Injectable({ providedIn: 'root' })
export class CityMasterResolve implements Resolve<ICityMaster> {
  constructor(private service: CityMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICityMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((cityMaster: HttpResponse<CityMaster>) => {
          if (cityMaster.body) {
            return of(cityMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CityMaster());
  }
}

export const cityMasterRoute: Routes = [
  {
    path: '',
    component: CityMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'CityMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: CityMasterDetailComponent,
    resolve: {
      cityMaster: CityMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CityMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: CityMasterUpdateComponent,
    resolve: {
      cityMaster: CityMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CityMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: CityMasterUpdateComponent,
    resolve: {
      cityMaster: CityMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CityMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
