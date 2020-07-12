import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'zone-master',
        loadChildren: () => import('./zone-master/zone-master.module').then(m => m.CourierserviceZoneMasterModule),
      },
      {
        path: 'country-master',
        loadChildren: () => import('./country-master/country-master.module').then(m => m.CourierserviceCountryMasterModule),
      },
      {
        path: 'state-master',
        loadChildren: () => import('./state-master/state-master.module').then(m => m.CourierserviceStateMasterModule),
      },
      {
        path: 'city-master',
        loadChildren: () => import('./city-master/city-master.module').then(m => m.CourierserviceCityMasterModule),
      },
      {
        path: 'company-master',
        loadChildren: () => import('./company-master/company-master.module').then(m => m.CourierserviceCompanyMasterModule),
      },
      {
        path: 'branch-master',
        loadChildren: () => import('./branch-master/branch-master.module').then(m => m.CourierserviceBranchMasterModule),
      },
      {
        path: 'service-master',
        loadChildren: () => import('./service-master/service-master.module').then(m => m.CourierserviceServiceMasterModule),
      },
      {
        path: 'network-master',
        loadChildren: () => import('./network-master/network-master.module').then(m => m.CourierserviceNetworkMasterModule),
      },
      {
        path: 'standard-tariff',
        loadChildren: () => import('./standard-tariff/standard-tariff.module').then(m => m.CourierserviceStandardTariffModule),
      },
    ]),
  ],
})
export class CourierserviceEntityModule {}
