import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IZoneMaster } from 'app/shared/model/zone-master.model';
import { IZoneMasterSearch } from 'app/shared/model/zone-master-search.model';

type EntityResponseType = HttpResponse<IZoneMaster>;
type EntityArrayResponseType = HttpResponse<IZoneMaster[]>;

@Injectable({ providedIn: 'root' })
export class ZoneMasterService {
  public resourceUrl = SERVER_API_URL + 'api/zone-masters';

  constructor(protected http: HttpClient) {}

  create(zoneMaster: IZoneMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(zoneMaster);
    return this.http
      .post<IZoneMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(zoneMaster: IZoneMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(zoneMaster);
    return this.http
      .put<IZoneMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IZoneMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IZoneMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  queryCustom(zoneMasterSearch?: IZoneMasterSearch): Observable<HttpResponse<IZoneMaster[]>> {
    return this.http.post<IZoneMaster[]>(this.resourceUrl + '-filter', zoneMasterSearch, { observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(zoneMaster: IZoneMaster): IZoneMaster {
    const copy: IZoneMaster = Object.assign({}, zoneMaster, {
      createdDate: zoneMaster.createdDate && zoneMaster.createdDate.isValid() ? zoneMaster.createdDate.format(DATE_FORMAT) : undefined,
      lastUpdatedDate:
        zoneMaster.lastUpdatedDate && zoneMaster.lastUpdatedDate.isValid() ? zoneMaster.lastUpdatedDate.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.createdDate = res.body.createdDate ? moment(res.body.createdDate) : undefined;
      res.body.lastUpdatedDate = res.body.lastUpdatedDate ? moment(res.body.lastUpdatedDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((zoneMaster: IZoneMaster) => {
        zoneMaster.createdDate = zoneMaster.createdDate ? moment(zoneMaster.createdDate) : undefined;
        zoneMaster.lastUpdatedDate = zoneMaster.lastUpdatedDate ? moment(zoneMaster.lastUpdatedDate) : undefined;
      });
    }
    return res;
  }
}
