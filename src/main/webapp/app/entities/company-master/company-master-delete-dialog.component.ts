import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from './company-master.service';

@Component({
  templateUrl: './company-master-delete-dialog.component.html',
})
export class CompanyMasterDeleteDialogComponent {
  companyMaster?: ICompanyMaster;

  constructor(
    protected companyMasterService: CompanyMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.companyMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('companyMasterListModification');
      this.activeModal.close();
    });
  }
}
