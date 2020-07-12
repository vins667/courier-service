import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { StateMasterComponent } from './state-master.component';
import { StateMasterDetailComponent } from './state-master-detail.component';
import { StateMasterUpdateComponent } from './state-master-update.component';
import { StateMasterDeleteDialogComponent } from './state-master-delete-dialog.component';
import { stateMasterRoute } from './state-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(stateMasterRoute)],
  declarations: [StateMasterComponent, StateMasterDetailComponent, StateMasterUpdateComponent, StateMasterDeleteDialogComponent],
  entryComponents: [StateMasterDeleteDialogComponent],
})
export class CourierserviceStateMasterModule {}
