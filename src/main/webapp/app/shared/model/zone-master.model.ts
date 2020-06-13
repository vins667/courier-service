import { Moment } from 'moment';

export interface IZoneMaster {
  id?: number;
  zoneCode?: string;
  zoneName?: string;
  createdBy?: string;
  createdDate?: Moment;
  lastUpdatedBy?: string;
  lastUpdatedDate?: Moment;
}

export class ZoneMaster implements IZoneMaster {
  constructor(
    public id?: number,
    public zoneCode?: string,
    public zoneName?: string,
    public createdBy?: string,
    public createdDate?: Moment,
    public lastUpdatedBy?: string,
    public lastUpdatedDate?: Moment
  ) {}
}
