import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IStandardTariff } from 'app/shared/model/standard-tariff.model';
import { StandardTariffService } from './standard-tariff.service';

@Component({
  templateUrl: './standard-tariff-delete-dialog.component.html',
})
export class StandardTariffDeleteDialogComponent {
  standardTariff?: IStandardTariff;

  constructor(
    protected standardTariffService: StandardTariffService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.standardTariffService.delete(id).subscribe(() => {
      this.eventManager.broadcast('standardTariffListModification');
      this.activeModal.close();
    });
  }
}
