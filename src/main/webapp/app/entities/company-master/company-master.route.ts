import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICompanyMaster, CompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from './company-master.service';
import { CompanyMasterComponent } from './company-master.component';
import { CompanyMasterDetailComponent } from './company-master-detail.component';
import { CompanyMasterUpdateComponent } from './company-master-update.component';

@Injectable({ providedIn: 'root' })
export class CompanyMasterResolve implements Resolve<ICompanyMaster> {
  constructor(private service: CompanyMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICompanyMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((companyMaster: HttpResponse<CompanyMaster>) => {
          if (companyMaster.body) {
            return of(companyMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new CompanyMaster());
  }
}

export const companyMasterRoute: Routes = [
  {
    path: '',
    component: CompanyMasterComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams,
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'CompanyMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: CompanyMasterDetailComponent,
    resolve: {
      companyMaster: CompanyMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CompanyMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: CompanyMasterUpdateComponent,
    resolve: {
      companyMaster: CompanyMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CompanyMasters',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: CompanyMasterUpdateComponent,
    resolve: {
      companyMaster: CompanyMasterResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'CompanyMasters',
    },
    canActivate: [UserRouteAccessService],
  },
];
