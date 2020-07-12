import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IStateMaster, StateMaster } from 'app/shared/model/state-master.model';
import { StateMasterService } from './state-master.service';
import { ICountryMaster } from 'app/shared/model/country-master.model';
import { CountryMasterService } from 'app/entities/country-master/country-master.service';

@Component({
  selector: 'jhi-state-master-update',
  templateUrl: './state-master-update.component.html',
})
export class StateMasterUpdateComponent implements OnInit {
  isSaving = false;
  countrymasters: ICountryMaster[] = [];

  editForm = this.fb.group({
    id: [],
    code: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(5)]],
    stateName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    countryMasterId: [null, Validators.required],
  });

  constructor(
    protected stateMasterService: StateMasterService,
    protected countryMasterService: CountryMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ stateMaster }) => {
      this.updateForm(stateMaster);

      this.countryMasterService.query().subscribe((res: HttpResponse<ICountryMaster[]>) => (this.countrymasters = res.body || []));
    });
  }

  updateForm(stateMaster: IStateMaster): void {
    this.editForm.patchValue({
      id: stateMaster.id,
      code: stateMaster.code,
      stateName: stateMaster.stateName,
      countryMasterId: stateMaster.countryMasterId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const stateMaster = this.createFromForm();
    if (stateMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.stateMasterService.update(stateMaster));
    } else {
      this.subscribeToSaveResponse(this.stateMasterService.create(stateMaster));
    }
  }

  private createFromForm(): IStateMaster {
    return {
      ...new StateMaster(),
      id: this.editForm.get(['id'])!.value,
      code: this.editForm.get(['code'])!.value,
      stateName: this.editForm.get(['stateName'])!.value,
      countryMasterId: this.editForm.get(['countryMasterId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStateMaster>>): void {
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

  trackById(index: number, item: ICountryMaster): any {
    return item.id;
  }
}
