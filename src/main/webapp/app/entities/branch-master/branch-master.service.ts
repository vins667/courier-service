import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IBranchMaster } from 'app/shared/model/branch-master.model';

type EntityResponseType = HttpResponse<IBranchMaster>;
type EntityArrayResponseType = HttpResponse<IBranchMaster[]>;

@Injectable({ providedIn: 'root' })
export class BranchMasterService {
  public resourceUrl = SERVER_API_URL + 'api/branch-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/branch-masters';

  constructor(protected http: HttpClient) {}

  create(branchMaster: IBranchMaster): Observable<EntityResponseType> {
    return this.http.post<IBranchMaster>(this.resourceUrl, branchMaster, { observe: 'response' });
  }

  update(branchMaster: IBranchMaster): Observable<EntityResponseType> {
    return this.http.put<IBranchMaster>(this.resourceUrl, branchMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IBranchMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IBranchMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IBranchMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
