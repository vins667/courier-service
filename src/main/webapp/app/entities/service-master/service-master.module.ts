import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { ServiceMasterComponent } from './service-master.component';
import { ServiceMasterDetailComponent } from './service-master-detail.component';
import { ServiceMasterUpdateComponent } from './service-master-update.component';
import { ServiceMasterDeleteDialogComponent } from './service-master-delete-dialog.component';
import { serviceMasterRoute } from './service-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(serviceMasterRoute)],
  declarations: [ServiceMasterComponent, ServiceMasterDetailComponent, ServiceMasterUpdateComponent, ServiceMasterDeleteDialogComponent],
  entryComponents: [ServiceMasterDeleteDialogComponent],
})
export class CourierserviceServiceMasterModule {}
