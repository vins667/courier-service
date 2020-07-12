import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IStateMaster } from 'app/shared/model/state-master.model';

type EntityResponseType = HttpResponse<IStateMaster>;
type EntityArrayResponseType = HttpResponse<IStateMaster[]>;

@Injectable({ providedIn: 'root' })
export class StateMasterService {
  public resourceUrl = SERVER_API_URL + 'api/state-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/state-masters';

  constructor(protected http: HttpClient) {}

  create(stateMaster: IStateMaster): Observable<EntityResponseType> {
    return this.http.post<IStateMaster>(this.resourceUrl, stateMaster, { observe: 'response' });
  }

  update(stateMaster: IStateMaster): Observable<EntityResponseType> {
    return this.http.put<IStateMaster>(this.resourceUrl, stateMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IStateMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IStateMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IStateMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
