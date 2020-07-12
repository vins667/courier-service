import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { INetworkMaster, NetworkMaster } from 'app/shared/model/network-master.model';
import { NetworkMasterService } from './network-master.service';
import { ICityMaster } from 'app/shared/model/city-master.model';
import { CityMasterService } from 'app/entities/city-master/city-master.service';

@Component({
  selector: 'jhi-network-master-update',
  templateUrl: './network-master-update.component.html',
})
export class NetworkMasterUpdateComponent implements OnInit {
  isSaving = false;
  citymasters: ICityMaster[] = [];

  editForm = this.fb.group({
    id: [],
    networkCode: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
    networkName: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    contactPerson: [null, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    contactNumber: [null, [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
    address: [null, [Validators.required]],
    website: [null, [Validators.required]],
    email: [null, [Validators.required]],
    cityMasterId: [null, Validators.required],
  });

  constructor(
    protected networkMasterService: NetworkMasterService,
    protected cityMasterService: CityMasterService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ networkMaster }) => {
      this.updateForm(networkMaster);

      this.cityMasterService.query().subscribe((res: HttpResponse<ICityMaster[]>) => (this.citymasters = res.body || []));
    });
  }

  updateForm(networkMaster: INetworkMaster): void {
    this.editForm.patchValue({
      id: networkMaster.id,
      networkCode: networkMaster.networkCode,
      networkName: networkMaster.networkName,
      contactPerson: networkMaster.contactPerson,
      contactNumber: networkMaster.contactNumber,
      address: networkMaster.address,
      website: networkMaster.website,
      email: networkMaster.email,
      cityMasterId: networkMaster.cityMasterId,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const networkMaster = this.createFromForm();
    if (networkMaster.id !== undefined) {
      this.subscribeToSaveResponse(this.networkMasterService.update(networkMaster));
    } else {
      this.subscribeToSaveResponse(this.networkMasterService.create(networkMaster));
    }
  }

  private createFromForm(): INetworkMaster {
    return {
      ...new NetworkMaster(),
      id: this.editForm.get(['id'])!.value,
      networkCode: this.editForm.get(['networkCode'])!.value,
      networkName: this.editForm.get(['networkName'])!.value,
      contactPerson: this.editForm.get(['contactPerson'])!.value,
      contactNumber: this.editForm.get(['contactNumber'])!.value,
      address: this.editForm.get(['address'])!.value,
      website: this.editForm.get(['website'])!.value,
      email: this.editForm.get(['email'])!.value,
      cityMasterId: this.editForm.get(['cityMasterId'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<INetworkMaster>>): void {
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

  trackById(index: number, item: ICityMaster): any {
    return item.id;
  }
}
