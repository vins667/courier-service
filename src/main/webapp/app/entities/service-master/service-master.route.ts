import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IServiceMaster, ServiceMaster } from 'app/shared/model/service-master.model';
import { ServiceMasterService } from './service-master.service';
import { ServiceMasterComponent } from './service-master.component';
import { ServiceMasterDetailComponent } from './service-master-detail.component';
import { ServiceMasterUpdateComponent } from './service-master-update.component';

@Injectable({ providedIn: 'root' })
export class ServiceMasterResolve implements Resolve<IServiceMaster> {
  constructor(private service: ServiceMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IServiceMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((serviceMaster: HttpResponse<ServiceMaster>) => {
          if (serviceMaster.body) {
            return of(serviceMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ServiceMaster());
  }
}

export const serviceMasterRoute: Routes = [
  {
    path: '',
    component: ServiceMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'ServiceMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ServiceMasterDetailComponent,
    resolve: {
      serviceMaster: ServiceMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ServiceMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ServiceMasterUpdateComponent,
    resolve: {
      serviceMaster: ServiceMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ServiceMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ServiceMasterUpdateComponent,
    resolve: {
      serviceMaster: ServiceMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ServiceMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
