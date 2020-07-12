import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { BranchMasterComponent } from './branch-master.component';
import { BranchMasterDetailComponent } from './branch-master-detail.component';
import { BranchMasterUpdateComponent } from './branch-master-update.component';
import { BranchMasterDeleteDialogComponent } from './branch-master-delete-dialog.component';
import { branchMasterRoute } from './branch-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(branchMasterRoute)],
  declarations: [BranchMasterComponent, BranchMasterDetailComponent, BranchMasterUpdateComponent, BranchMasterDeleteDialogComponent],
  entryComponents: [BranchMasterDeleteDialogComponent],
})
export class CourierserviceBranchMasterModule {}
