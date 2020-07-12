import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICountryMaster } from 'app/shared/model/country-master.model';
import { CountryMasterService } from './country-master.service';

@Component({
  templateUrl: './country-master-delete-dialog.component.html',
})
export class CountryMasterDeleteDialogComponent {
  countryMaster?: ICountryMaster;

  constructor(
    protected countryMasterService: CountryMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.countryMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('countryMasterListModification');
      this.activeModal.close();
    });
  }
}
