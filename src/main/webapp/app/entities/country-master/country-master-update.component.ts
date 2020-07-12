import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICountryMaster, CountryMaster } from 'app/shared/model/country-master.model';
import { CountryMasterService } from './country-master.service';

@Component({
  selector: 'jhi-country-master-update',
  templateUrl: './country-master-update.component.html',
})
export class CountryMasterUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    code: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(3)]],
    countryName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
  });

  constructor(protected countryMasterService: CountryMasterService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ countryMaster }) => {
      this.updateForm(countryMaster);
    });
  }

  updateForm(countryMaster: ICountryMaster): void {
    this.editForm.patchValue({
      id: countryMaster.id,
      code: countryMaster.code,
      countryName: countryMaster.countryName,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const countryMaster = this.createFromForm();
    if (countryMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.countryMasterService.update(countryMaster));
    } else {
      this.subscribeToSaveResponse(this.countryMasterService.create(countryMaster));
    }
  }

  private createFromForm(): ICountryMaster {
    return {
      ...new CountryMaster(),
      id: this.editForm.get(['id'])!.value,
      code: this.editForm.get(['code'])!.value,
      countryName: this.editForm.get(['countryName'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICountryMaster>>): void {
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
