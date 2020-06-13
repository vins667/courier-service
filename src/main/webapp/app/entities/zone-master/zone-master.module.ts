import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { ZoneMasterComponent } from './zone-master.component';
import { ZoneMasterDetailComponent } from './zone-master-detail.component';
import { ZoneMasterUpdateComponent } from './zone-master-update.component';
import { ZoneMasterDeleteDialogComponent } from './zone-master-delete-dialog.component';
import { zoneMasterRoute } from './zone-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(zoneMasterRoute)],
  declarations: [ZoneMasterComponent, ZoneMasterDetailComponent, ZoneMasterUpdateComponent, ZoneMasterDeleteDialogComponent],
  entryComponents: [ZoneMasterDeleteDialogComponent],
})
export class CourierserviceZoneMasterModule {}
