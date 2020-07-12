import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { ICountryMaster } from 'app/shared/model/country-master.model';

type EntityResponseType = HttpResponse<ICountryMaster>;
type EntityArrayResponseType = HttpResponse<ICountryMaster[]>;

@Injectable({ providedIn: 'root' })
export class CountryMasterService {
  public resourceUrl = SERVER_API_URL + 'api/country-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/country-masters';

  constructor(protected http: HttpClient) {}

  create(countryMaster: ICountryMaster): Observable<EntityResponseType> {
    return this.http.post<ICountryMaster>(this.resourceUrl, countryMaster, { observe: 'response' });
  }

  update(countryMaster: ICountryMaster): Observable<EntityResponseType> {
    return this.http.put<ICountryMaster>(this.resourceUrl, countryMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICountryMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICountryMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICountryMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
