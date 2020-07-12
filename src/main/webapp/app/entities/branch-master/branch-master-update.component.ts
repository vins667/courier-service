import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IBranchMaster, BranchMaster } from 'app/shared/model/branch-master.model';
import { BranchMasterService } from './branch-master.service';
import { ICompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from 'app/entities/company-master/company-master.service';
import { ICountryMaster } from 'app/shared/model/country-master.model';
import { CountryMasterService } from 'app/entities/country-master/country-master.service';

type SelectableEntity = ICompanyMaster | ICountryMaster;

@Component({
  selector: 'jhi-branch-master-update',
  templateUrl: './branch-master-update.component.html',
})
export class BranchMasterUpdateComponent implements OnInit {
  isSaving = false;
  companymasters: ICompanyMaster[] = [];
  countrymasters: ICountryMaster[] = [];

  editForm = this.fb.group({
    id: [],
    branchName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
    managerName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
    pinCode: [null, [Validators.required, Validators.minLength(6), Validators.maxLength(9)]],
    address: [null, [Validators.required]],
    email: [null, [Validators.required]],
    mobile: [null, [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
    companyMasterId: [null, Validators.required],
    countryMasterId: [null, Validators.required],
  });

  constructor(
    protected branchMasterService: BranchMasterService,
    protected companyMasterService: CompanyMasterService,
    protected countryMasterService: CountryMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ branchMaster }) => {
      this.updateForm(branchMaster);

      this.companyMasterService.query().subscribe((res: HttpResponse<ICompanyMaster[]>) => (this.companymasters = res.body || []));

      this.countryMasterService
        .query({ 'branchMasterId.specified': 'false' })
        .pipe(
          map((res: HttpResponse<ICountryMaster[]>) => {
            return res.body || [];
          })
        )
        .subscribe((resBody: ICountryMaster[]) => {
          if (!branchMaster.countryMasterId) {
            this.countrymasters = resBody;
          } else {
            this.countryMasterService
              .find(branchMaster.countryMasterId)
              .pipe(
                map((subRes: HttpResponse<ICountryMaster>) => {
                  return subRes.body ? [subRes.body].concat(resBody) : resBody;
                })
              )
              .subscribe((concatRes: ICountryMaster[]) => (this.countrymasters = concatRes));
          }
        });
    });
  }

  updateForm(branchMaster: IBranchMaster): void {
    this.editForm.patchValue({
      id: branchMaster.id,
      branchName: branchMaster.branchName,
      managerName: branchMaster.managerName,
      pinCode: branchMaster.pinCode,
      address: branchMaster.address,
      email: branchMaster.email,
      mobile: branchMaster.mobile,
      companyMasterId: branchMaster.companyMasterId,
      countryMasterId: branchMaster.countryMasterId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const branchMaster = this.createFromForm();
    if (branchMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.branchMasterService.update(branchMaster));
    } else {
      this.subscribeToSaveResponse(this.branchMasterService.create(branchMaster));
    }
  }

  private createFromForm(): IBranchMaster {
    return {
      ...new BranchMaster(),
      id: this.editForm.get(['id'])!.value,
      branchName: this.editForm.get(['branchName'])!.value,
      managerName: this.editForm.get(['managerName'])!.value,
      pinCode: this.editForm.get(['pinCode'])!.value,
      address: this.editForm.get(['address'])!.value,
      email: this.editForm.get(['email'])!.value,
      mobile: this.editForm.get(['mobile'])!.value,
      companyMasterId: this.editForm.get(['companyMasterId'])!.value,
      countryMasterId: this.editForm.get(['countryMasterId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IBranchMaster>>): void {
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
