import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'zone-master',
        loadChildren: () => import('./zone-master/zone-master.module').then(m => m.CourierserviceZoneMasterModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class CourierserviceEntityModule {}
