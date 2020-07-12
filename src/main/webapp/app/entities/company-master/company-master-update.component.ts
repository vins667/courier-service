import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICompanyMaster, CompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from './company-master.service';
import { IStateMaster } from 'app/shared/model/state-master.model';
import { StateMasterService } from 'app/entities/state-master/state-master.service';
import { ICountryMaster } from 'app/shared/model/country-master.model';
import { CountryMasterService } from 'app/entities/country-master/country-master.service';
import { ICityMaster } from 'app/shared/model/city-master.model';
import { CityMasterService } from 'app/entities/city-master/city-master.service';

type SelectableEntity = IStateMaster | ICountryMaster | ICityMaster;

@Component({
  selector: 'jhi-company-master-update',
  templateUrl: './company-master-update.component.html',
})
export class CompanyMasterUpdateComponent implements OnInit {
  isSaving = false;
  statemasters: IStateMaster[] = [];
  countrymasters: ICountryMaster[] = [];
  citymasters: ICityMaster[] = [];

  editForm = this.fb.group({
    id: [],
    companyName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(50)]],
    address: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(30)]],
    pinCode: [null, [Validators.required, Validators.minLength(6), Validators.maxLength(9)]],
    mdName: [null, [Validators.required]],
    mdContactNo: [null, [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
    mdEmailId: [null, [Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]],
    panNumber: [null, [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern('^[a-zA-Z0-9]*$')]],
    webSiteUrl: [
      null,
      [
        Validators.required,
        Validators.pattern(
          '^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+(\\.[a-z]{2,}){1,3}(#?\\/?[a-zA-Z0-9#]+)*\\/?(\\?[a-zA-Z0-9-_]+=[a-zA-Z0-9-%]+&?)?$'
        ),
      ],
    ],
    tinNumber: [null, [Validators.required]],
    gstNumber: [
      null,
      [
        Validators.required,
        Validators.minLength(15),
        Validators.maxLength(15),
        Validators.pattern('^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$'),
      ],
    ],
    stateMasterId: [null, Validators.required],
    countryMasterId: [null, Validators.required],
    cityMasterId: [null, Validators.required],
  });

  constructor(
    protected companyMasterService: CompanyMasterService,
    protected stateMasterService: StateMasterService,
    protected countryMasterService: CountryMasterService,
    protected cityMasterService: CityMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ companyMaster }) => {
      this.updateForm(companyMaster);

      this.stateMasterService.query().subscribe((res: HttpResponse<IStateMaster[]>) => (this.statemasters = res.body || []));

      this.countryMasterService.query().subscribe((res: HttpResponse<ICountryMaster[]>) => (this.countrymasters = res.body || []));

      this.cityMasterService.query().subscribe((res: HttpResponse<ICityMaster[]>) => (this.citymasters = res.body || []));
    });
  }

  updateForm(companyMaster: ICompanyMaster): void {
    this.editForm.patchValue({
      id: companyMaster.id,
      companyName: companyMaster.companyName,
      address: companyMaster.address,
      pinCode: companyMaster.pinCode,
      mdName: companyMaster.mdName,
      mdContactNo: companyMaster.mdContactNo,
      mdEmailId: companyMaster.mdEmailId,
      panNumber: companyMaster.panNumber,
      webSiteUrl: companyMaster.webSiteUrl,
      tinNumber: companyMaster.tinNumber,
      gstNumber: companyMaster.gstNumber,
      stateMasterId: companyMaster.stateMasterId,
      countryMasterId: companyMaster.countryMasterId,
      cityMasterId: companyMaster.cityMasterId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const companyMaster = this.createFromForm();
    if (companyMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.companyMasterService.update(companyMaster));
    } else {
      this.subscribeToSaveResponse(this.companyMasterService.create(companyMaster));
    }
  }

  private createFromForm(): ICompanyMaster {
    return {
      ...new CompanyMaster(),
      id: this.editForm.get(['id'])!.value,
      companyName: this.editForm.get(['companyName'])!.value,
      address: this.editForm.get(['address'])!.value,
      pinCode: this.editForm.get(['pinCode'])!.value,
      mdName: this.editForm.get(['mdName'])!.value,
      mdContactNo: this.editForm.get(['mdContactNo'])!.value,
      mdEmailId: this.editForm.get(['mdEmailId'])!.value,
      panNumber: this.editForm.get(['panNumber'])!.value,
      webSiteUrl: this.editForm.get(['webSiteUrl'])!.value,
      tinNumber: this.editForm.get(['tinNumber'])!.value,
      gstNumber: this.editForm.get(['gstNumber'])!.value,
      stateMasterId: this.editForm.get(['stateMasterId'])!.value,
      countryMasterId: this.editForm.get(['countryMasterId'])!.value,
      cityMasterId: this.editForm.get(['cityMasterId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICompanyMaster>>): void {
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
