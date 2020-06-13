import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import './vendor';
import { CourierserviceSharedModule } from 'app/shared/shared.module';
import { CourierserviceCoreModule } from 'app/core/core.module';
import { CourierserviceAppRoutingModule } from './app-routing.module';
import { CourierserviceHomeModule } from './home/home.module';
import { CourierserviceEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { CourierserviceDashboardModule } from './dashboard/dashboard.module';
import { MenuDetailComponent } from './layouts/navbar/menu-detail.component';
import { UserDetailComponent } from './layouts/navbar/userdetail.component';

@NgModule({
  imports: [
    BrowserModule,
    CourierserviceSharedModule,
    CourierserviceCoreModule,
    CourierserviceHomeModule,
    CourierserviceDashboardModule,
    CourierserviceEntityModule,
    CourierserviceAppRoutingModule,
  ],
  declarations: [
     MainComponent, 
     NavbarComponent,
     UserDetailComponent,
     MenuDetailComponent,
     ErrorComponent, 
     PageRibbonComponent, 
     FooterComponent
    ],
  bootstrap: [MainComponent],
})
export class CourierserviceAppModule {}
