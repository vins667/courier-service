import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IStateMaster } from 'app/shared/model/state-master.model';
import { StateMasterService } from './state-master.service';

@Component({
  templateUrl: './state-master-delete-dialog.component.html',
})
export class StateMasterDeleteDialogComponent {
  stateMaster?: IStateMaster;

  constructor(
    protected stateMasterService: StateMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.stateMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('stateMasterListModification');
      this.activeModal.close();
    });
  }
}
