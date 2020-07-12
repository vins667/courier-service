import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBranchMaster } from 'app/shared/model/branch-master.model';
import { BranchMasterService } from './branch-master.service';

@Component({
  templateUrl: './branch-master-delete-dialog.component.html',
})
export class BranchMasterDeleteDialogComponent {
  branchMaster?: IBranchMaster;

  constructor(
    protected branchMasterService: BranchMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.branchMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('branchMasterListModification');
      this.activeModal.close();
    });
  }
}
