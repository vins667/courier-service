import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { StandardTariffComponent } from './standard-tariff.component';
import { StandardTariffDetailComponent } from './standard-tariff-detail.component';
import { StandardTariffUpdateComponent } from './standard-tariff-update.component';
import { StandardTariffDeleteDialogComponent } from './standard-tariff-delete-dialog.component';
import { standardTariffRoute } from './standard-tariff.route';

@NgModule({
  imports: [CourierserviceSharedModule, RouterModule.forChild(standardTariffRoute)],
  declarations: [
    StandardTariffComponent,
    StandardTariffDetailComponent,
    StandardTariffUpdateComponent,
    StandardTariffDeleteDialogComponent,
  ],
  entryComponents: [StandardTariffDeleteDialogComponent],
})
export class CourierserviceStandardTariffModule {}
