import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IZoneMaster, ZoneMaster } from 'app/shared/model/zone-master.model';
import { ZoneMasterService } from './zone-master.service';

@Component({
  selector: 'jhi-zone-master-update',
  templateUrl: './zone-master-update.component.html',
})
export class ZoneMasterUpdateComponent implements OnInit {
  isSaving = false;
  createdDateDp: any;
  lastUpdatedDateDp: any;

  editForm = this.fb.group({
    id: [],
    zoneCode: [null, [Validators.required, Validators.maxLength(10)]],
    zoneName: [null, [Validators.required, Validators.maxLength(100)]],
    createdBy: [null, [Validators.maxLength(50)]],
    createdDate: [],
    lastUpdatedBy: [null, [Validators.maxLength(50)]],
    lastUpdatedDate: [],
  });

  constructor(protected zoneMasterService: ZoneMasterService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ zoneMaster }) => {
      this.updateForm(zoneMaster);
    });
  }

  updateForm(zoneMaster: IZoneMaster): void {
    this.editForm.patchValue({
      id: zoneMaster.id,
      zoneCode: zoneMaster.zoneCode,
      zoneName: zoneMaster.zoneName,
      createdBy: zoneMaster.createdBy,
      createdDate: zoneMaster.createdDate,
      lastUpdatedBy: zoneMaster.lastUpdatedBy,
      lastUpdatedDate: zoneMaster.lastUpdatedDate,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const zoneMaster = this.createFromForm();
    if (zoneMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.zoneMasterService.update(zoneMaster));
    } else {
      this.subscribeToSaveResponse(this.zoneMasterService.create(zoneMaster));
    }
  }

  private createFromForm(): IZoneMaster {
    return {
      ...new ZoneMaster(),
      id: this.editForm.get(['id'])!.value,
      zoneCode: this.editForm.get(['zoneCode'])!.value,
      zoneName: this.editForm.get(['zoneName'])!.value,
      createdBy: this.editForm.get(['createdBy'])!.value,
      createdDate: this.editForm.get(['createdDate'])!.value,
      lastUpdatedBy: this.editForm.get(['lastUpdatedBy'])!.value,
      lastUpdatedDate: this.editForm.get(['lastUpdatedDate'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IZoneMaster>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
