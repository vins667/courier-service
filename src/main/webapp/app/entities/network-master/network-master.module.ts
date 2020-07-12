import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { NetworkMasterComponent } from './network-master.component';
import { NetworkMasterDetailComponent } from './network-master-detail.component';
import { NetworkMasterUpdateComponent } from './network-master-update.component';
import { NetworkMasterDeleteDialogComponent } from './network-master-delete-dialog.component';
import { networkMasterRoute } from './network-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(networkMasterRoute)],
  declarations: [NetworkMasterComponent, NetworkMasterDetailComponent, NetworkMasterUpdateComponent, NetworkMasterDeleteDialogComponent],
  entryComponents: [NetworkMasterDeleteDialogComponent],
})
export class CourierserviceNetworkMasterModule {}
