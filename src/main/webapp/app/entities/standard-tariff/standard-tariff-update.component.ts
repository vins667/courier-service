import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IStandardTariff, StandardTariff } from 'app/shared/model/standard-tariff.model';
import { StandardTariffService } from './standard-tariff.service';
import { INetworkMaster } from 'app/shared/model/network-master.model';
import { NetworkMasterService } from 'app/entities/network-master/network-master.service';
import { IServiceMaster } from 'app/shared/model/service-master.model';
import { ServiceMasterService } from 'app/entities/service-master/service-master.service';
import { ICityMaster } from 'app/shared/model/city-master.model';
import { CityMasterService } from 'app/entities/city-master/city-master.service';
import { ICode } from 'app/shared/model/code.model';

type SelectableEntity = INetworkMaster | IServiceMaster | ICityMaster;

@Component({
  selector: 'jhi-standard-tariff-update',
  templateUrl: './standard-tariff-update.component.html',
})
export class StandardTariffUpdateComponent implements OnInit {
  isSaving = false;
  networkmasters: INetworkMaster[] = [];
  servicemasters: IServiceMaster[] = [];
  citymasters: ICityMaster[] = [];
  locationWise: ICode[] = [];
  locations: ICode[] = [];
  editForm = this.fb.group({
    id: [],
    fromWeight: [null, [Validators.required]],
    toWeight: [null, [Validators.required]],
    dox: [null, [Validators.required]],
    nDox: [null, [Validators.required]],
    networkMasterId: [null, Validators.required],
    serviceMasterId: [null, Validators.required],
    cityMasterId: [null, Validators.required],
    locationWiseId: [],
    locationWise: [null, Validators.required],
    location: [null, Validators.required],
  });

  constructor(
    protected standardTariffService: StandardTariffService,
    protected networkMasterService: NetworkMasterService,
    protected serviceMasterService: ServiceMasterService,
    protected cityMasterService: CityMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ standardTariff }) => {
      this.updateForm(standardTariff);

      this.networkMasterService.query().subscribe((res: HttpResponse<INetworkMaster[]>) => (this.networkmasters = res.body || []));

      this.serviceMasterService.query().subscribe((res: HttpResponse<IServiceMaster[]>) => (this.servicemasters = res.body || []));

      this.cityMasterService.query().subscribe((res: HttpResponse<ICityMaster[]>) => (this.citymasters = res.body || []));
      this.locationWise = this.standardTariffService.getLocationWise();
      console.log('location Wise', this.locationWise);
    });
  }

  updateForm(standardTariff: IStandardTariff): void {
    this.editForm.patchValue({
      id: standardTariff.id,
      fromWeight: standardTariff.fromWeight,
      toWeight: standardTariff.toWeight,
      dox: standardTariff.dox,
      nDox: standardTariff.nDox,
      networkMasterId: standardTariff.networkMasterId,
      serviceMasterId: standardTariff.serviceMasterId,
      cityMasterId: standardTariff.cityMasterId,
      locationWiseId: standardTariff.locationWiseId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const standardTariff = this.createFromForm();
    if (standardTariff.id !== undefined) {
      this.subscribeToSaveResponse(this.standardTariffService.update(standardTariff));
    } else {
      this.subscribeToSaveResponse(this.standardTariffService.create(standardTariff));
    }
  }

  private createFromForm(): IStandardTariff {
    return {
      ...new StandardTariff(),
      id: this.editForm.get(['id'])!.value,
      fromWeight: this.editForm.get(['fromWeight'])!.value,
      toWeight: this.editForm.get(['toWeight'])!.value,
      dox: this.editForm.get(['dox'])!.value,
      nDox: this.editForm.get(['nDox'])!.value,
      networkMasterId: this.editForm.get(['networkMasterId'])!.value,
      serviceMasterId: this.editForm.get(['serviceMasterId'])!.value,
      cityMasterId: this.editForm.get(['cityMasterId'])!.value,
      locationWiseId: this.editForm.get(['locationWiseId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStandardTariff>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }
  onLocationWiseChange(code: string) {
    console.log('code', code);
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
