import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IZoneMaster, ZoneMaster } from 'app/shared/model/zone-master.model';
import { ZoneMasterService } from './zone-master.service';
import { ZoneMasterComponent } from './zone-master.component';
import { ZoneMasterDetailComponent } from './zone-master-detail.component';
import { ZoneMasterUpdateComponent } from './zone-master-update.component';

@Injectable({ providedIn: 'root' })
export class ZoneMasterResolve implements Resolve<IZoneMaster> {
  constructor(private service: ZoneMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IZoneMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((zoneMaster: HttpResponse<ZoneMaster>) => {
          if (zoneMaster.body) {
            return of(zoneMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ZoneMaster());
  }
}

export const zoneMasterRoute: Routes = [
  {
    path: '',
    component: ZoneMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'ZoneMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ZoneMasterDetailComponent,
    resolve: {
      zoneMaster: ZoneMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ZoneMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ZoneMasterUpdateComponent,
    resolve: {
      zoneMaster: ZoneMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ZoneMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ZoneMasterUpdateComponent,
    resolve: {
      zoneMaster: ZoneMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ZoneMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
