import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { ICityMaster } from 'app/shared/model/city-master.model';

type EntityResponseType = HttpResponse<ICityMaster>;
type EntityArrayResponseType = HttpResponse<ICityMaster[]>;

@Injectable({ providedIn: 'root' })
export class CityMasterService {
  public resourceUrl = SERVER_API_URL + 'api/city-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/city-masters';

  constructor(protected http: HttpClient) {}

  create(cityMaster: ICityMaster): Observable<EntityResponseType> {
    return this.http.post<ICityMaster>(this.resourceUrl, cityMaster, { observe: 'response' });
  }

  update(cityMaster: ICityMaster): Observable<EntityResponseType> {
    return this.http.put<ICityMaster>(this.resourceUrl, cityMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICityMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICityMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICityMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
