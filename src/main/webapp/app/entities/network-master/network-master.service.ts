import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { INetworkMaster } from 'app/shared/model/network-master.model';

type EntityResponseType = HttpResponse<INetworkMaster>;
type EntityArrayResponseType = HttpResponse<INetworkMaster[]>;

@Injectable({ providedIn: 'root' })
export class NetworkMasterService {
  public resourceUrl = SERVER_API_URL + 'api/network-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/network-masters';

  constructor(protected http: HttpClient) {}

  create(networkMaster: INetworkMaster): Observable<EntityResponseType> {
    return this.http.post<INetworkMaster>(this.resourceUrl, networkMaster, { observe: 'response' });
  }

  update(networkMaster: INetworkMaster): Observable<EntityResponseType> {
    return this.http.put<INetworkMaster>(this.resourceUrl, networkMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<INetworkMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<INetworkMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<INetworkMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
