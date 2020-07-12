import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IBranchMaster, BranchMaster } from 'app/shared/model/branch-master.model';
import { BranchMasterService } from './branch-master.service';
import { BranchMasterComponent } from './branch-master.component';
import { BranchMasterDetailComponent } from './branch-master-detail.component';
import { BranchMasterUpdateComponent } from './branch-master-update.component';

@Injectable({ providedIn: 'root' })
export class BranchMasterResolve implements Resolve<IBranchMaster> {
  constructor(private service: BranchMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IBranchMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((branchMaster: HttpResponse<BranchMaster>) => {
          if (branchMaster.body) {
            return of(branchMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new BranchMaster());
  }
}

export const branchMasterRoute: Routes = [
  {
    path: '',
    component: BranchMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'BranchMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: BranchMasterDetailComponent,
    resolve: {
      branchMaster: BranchMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'BranchMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: BranchMasterUpdateComponent,
    resolve: {
      branchMaster: BranchMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'BranchMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: BranchMasterUpdateComponent,
    resolve: {
      branchMaster: BranchMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'BranchMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
