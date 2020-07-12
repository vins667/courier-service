import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { CompanyMasterComponent } from './company-master.component';
import { CompanyMasterDetailComponent } from './company-master-detail.component';
import { CompanyMasterUpdateComponent } from './company-master-update.component';
import { CompanyMasterDeleteDialogComponent } from './company-master-delete-dialog.component';
import { companyMasterRoute } from './company-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(companyMasterRoute)],
  declarations: [CompanyMasterComponent, CompanyMasterDetailComponent, CompanyMasterUpdateComponent, CompanyMasterDeleteDialogComponent],
  entryComponents: [CompanyMasterDeleteDialogComponent],
})
export class CourierserviceCompanyMasterModule {}
