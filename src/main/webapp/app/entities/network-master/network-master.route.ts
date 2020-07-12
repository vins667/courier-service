import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { INetworkMaster, NetworkMaster } from 'app/shared/model/network-master.model';
import { NetworkMasterService } from './network-master.service';
import { NetworkMasterComponent } from './network-master.component';
import { NetworkMasterDetailComponent } from './network-master-detail.component';
import { NetworkMasterUpdateComponent } from './network-master-update.component';

@Injectable({ providedIn: 'root' })
export class NetworkMasterResolve implements Resolve<INetworkMaster> {
  constructor(private service: NetworkMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<INetworkMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((networkMaster: HttpResponse<NetworkMaster>) => {
          if (networkMaster.body) {
            return of(networkMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new NetworkMaster());
  }
}

export const networkMasterRoute: Routes = [
  {
    path: '',
    component: NetworkMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'NetworkMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: NetworkMasterDetailComponent,
    resolve: {
      networkMaster: NetworkMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'NetworkMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: NetworkMasterUpdateComponent,
    resolve: {
      networkMaster: NetworkMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'NetworkMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: NetworkMasterUpdateComponent,
    resolve: {
      networkMaster: NetworkMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'NetworkMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
