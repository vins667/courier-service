import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IStandardTariff } from 'app/shared/model/standard-tariff.model';
import { CommonService } from 'app/shared/services/common.service';
import { ICode } from 'app/shared/model/code.model';

type EntityResponseType = HttpResponse<IStandardTariff>;
type EntityArrayResponseType = HttpResponse<IStandardTariff[]>;

@Injectable({ providedIn: 'root' })
export class StandardTariffService {
  public resourceUrl = SERVER_API_URL + 'api/standard-tariffs';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/standard-tariffs';

  constructor(protected http: HttpClient, public commonService: CommonService) {}

  create(standardTariff: IStandardTariff): Observable<EntityResponseType> {
    return this.http.post<IStandardTariff>(this.resourceUrl, standardTariff, { observe: 'response' });
  }

  update(standardTariff: IStandardTariff): Observable<EntityResponseType> {
    return this.http.put<IStandardTariff>(this.resourceUrl, standardTariff, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IStandardTariff>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IStandardTariff[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IStandardTariff[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }

  getLocationWise(): ICode[] {
    return this.commonService.getLocationWise();
  }
}
