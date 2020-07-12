import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IServiceMaster } from 'app/shared/model/service-master.model';

type EntityResponseType = HttpResponse<IServiceMaster>;
type EntityArrayResponseType = HttpResponse<IServiceMaster[]>;

@Injectable({ providedIn: 'root' })
export class ServiceMasterService {
  public resourceUrl = SERVER_API_URL + 'api/service-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/service-masters';

  constructor(protected http: HttpClient) {}

  create(serviceMaster: IServiceMaster): Observable<EntityResponseType> {
    return this.http.post<IServiceMaster>(this.resourceUrl, serviceMaster, { observe: 'response' });
  }

  update(serviceMaster: IServiceMaster): Observable<EntityResponseType> {
    return this.http.put<IServiceMaster>(this.resourceUrl, serviceMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IServiceMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IServiceMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IServiceMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
