import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { DASHBOARD_ROUTE, DashboardComponent } from './';

@NgModule({
    imports: [BrowserModule, RouterModule.forChild(DASHBOARD_ROUTE)],
    declarations: [DashboardComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CourierserviceDashboardModule {}
