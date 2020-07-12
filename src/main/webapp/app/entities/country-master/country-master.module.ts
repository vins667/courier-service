import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { CountryMasterComponent } from './country-master.component';
import { CountryMasterDetailComponent } from './country-master-detail.component';
import { CountryMasterUpdateComponent } from './country-master-update.component';
import { CountryMasterDeleteDialogComponent } from './country-master-delete-dialog.component';
import { countryMasterRoute } from './country-master.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(countryMasterRoute)],
  declarations: [CountryMasterComponent, CountryMasterDetailComponent, CountryMasterUpdateComponent, CountryMasterDeleteDialogComponent],
  entryComponents: [CountryMasterDeleteDialogComponent],
})
export class CourierserviceCountryMasterModule {}
