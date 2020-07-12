import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICompanyMaster } from 'app/shared/model/company-master.model';

@Component({
  selector: 'jhi-company-master-detail',
  templateUrl: './company-master-detail.component.html',
})
export class CompanyMasterDetailComponent implements OnInit {
  companyMaster: ICompanyMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ companyMaster }) => (this.companyMaster = companyMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
