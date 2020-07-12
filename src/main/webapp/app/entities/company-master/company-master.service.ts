import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { ICompanyMaster } from 'app/shared/model/company-master.model';

type EntityResponseType = HttpResponse<ICompanyMaster>;
type EntityArrayResponseType = HttpResponse<ICompanyMaster[]>;

@Injectable({ providedIn: 'root' })
export class CompanyMasterService {
  public resourceUrl = SERVER_API_URL + 'api/company-masters';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/company-masters';

  constructor(protected http: HttpClient) {}

  create(companyMaster: ICompanyMaster): Observable<EntityResponseType> {
    return this.http.post<ICompanyMaster>(this.resourceUrl, companyMaster, { observe: 'response' });
  }

  update(companyMaster: ICompanyMaster): Observable<EntityResponseType> {
    return this.http.put<ICompanyMaster>(this.resourceUrl, companyMaster, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICompanyMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICompanyMaster[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICompanyMaster[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
