import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICityMaster } from 'app/shared/model/city-master.model';
import { CityMasterService } from './city-master.service';

@Component({
  templateUrl: './city-master-delete-dialog.component.html',
})
export class CityMasterDeleteDialogComponent {
  cityMaster?: ICityMaster;

  constructor(
    protected cityMasterService: CityMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.cityMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('cityMasterListModification');
      this.activeModal.close();
    });
  }
}
