import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { CityMasterComponent } from './city-master.component';
import { CityMasterDetailComponent } from './city-master-detail.component';
import { CityMasterUpdateComponent } from './city-master-update.component';
import { CityMasterDeleteDialogComponent } from './city-master-delete-dialog.component';
import { cityMasterRoute } from './city-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(cityMasterRoute)],
  declarations: [CityMasterComponent, CityMasterDetailComponent, CityMasterUpdateComponent, CityMasterDeleteDialogComponent],
  entryComponents: [CityMasterDeleteDialogComponent],
})
export class CourierserviceCityMasterModule {}
