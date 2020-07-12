import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICityMaster, CityMaster } from 'app/shared/model/city-master.model';
import { CityMasterService } from './city-master.service';
import { IStateMaster } from 'app/shared/model/state-master.model';
import { StateMasterService } from 'app/entities/state-master/state-master.service';

@Component({
  selector: 'jhi-city-master-update',
  templateUrl: './city-master-update.component.html',
})
export class CityMasterUpdateComponent implements OnInit {
  isSaving = false;
  statemasters: IStateMaster[] = [];

  editForm = this.fb.group({
    id: [],
    code: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    cityName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    pinCode: [null, [Validators.required, Validators.minLength(6), Validators.maxLength(9)]],
    stateMasterId: [null, Validators.required],
  });

  constructor(
    protected cityMasterService: CityMasterService,
    protected stateMasterService: StateMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cityMaster }) => {
      this.updateForm(cityMaster);

      this.stateMasterService.query().subscribe((res: HttpResponse<IStateMaster[]>) => (this.statemasters = res.body || []));
    });
  }

  updateForm(cityMaster: ICityMaster): void {
    this.editForm.patchValue({
      id: cityMaster.id,
      code: cityMaster.code,
      cityName: cityMaster.cityName,
      pinCode: cityMaster.pinCode,
      stateMasterId: cityMaster.stateMasterId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const cityMaster = this.createFromForm();
    if (cityMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.cityMasterService.update(cityMaster));
    } else {
      this.subscribeToSaveResponse(this.cityMasterService.create(cityMaster));
    }
  }

  private createFromForm(): ICityMaster {
    return {
      ...new CityMaster(),
      id: this.editForm.get(['id'])!.value,
      code: this.editForm.get(['code'])!.value,
      cityName: this.editForm.get(['cityName'])!.value,
      pinCode: this.editForm.get(['pinCode'])!.value,
      stateMasterId: this.editForm.get(['stateMasterId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICityMaster>>): void {
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

  trackById(index: number, item: IStateMaster): any {
    return item.id;
  }
}
