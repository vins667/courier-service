import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IServiceMaster, ServiceMaster } from 'app/shared/model/service-master.model';
import { ServiceMasterService } from './service-master.service';

@Component({
  selector: 'jhi-service-master-update',
  templateUrl: './service-master-update.component.html',
})
export class ServiceMasterUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    serviceCode: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
    serviceName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    dimensioncharge: [null, [Validators.required]],
  });

  constructor(protected serviceMasterService: ServiceMasterService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ serviceMaster }) => {
      this.updateForm(serviceMaster);
    });
  }

  updateForm(serviceMaster: IServiceMaster): void {
    this.editForm.patchValue({
      id: serviceMaster.id,
      serviceCode: serviceMaster.serviceCode,
      serviceName: serviceMaster.serviceName,
      dimensioncharge: serviceMaster.dimensioncharge,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const serviceMaster = this.createFromForm();
    if (serviceMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.serviceMasterService.update(serviceMaster));
    } else {
      this.subscribeToSaveResponse(this.serviceMasterService.create(serviceMaster));
    }
  }

  private createFromForm(): IServiceMaster {
    return {
      ...new ServiceMaster(),
      id: this.editForm.get(['id'])!.value,
      serviceCode: this.editForm.get(['serviceCode'])!.value,
      serviceName: this.editForm.get(['serviceName'])!.value,
      dimensioncharge: this.editForm.get(['dimensioncharge'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IServiceMaster>>): void {
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
