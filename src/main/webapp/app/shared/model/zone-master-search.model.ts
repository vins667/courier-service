export interface IZoneMasterSearch {
  zoneCode?: string;
  zoneName?: string;
  page?: any;
  size?: number;
  pageNo?: number;
}
export class ZoneMasterSearch implements IZoneMasterSearch {
  constructor(
    public id?: number,
    public zoneCode?: string,
    public zoneName?: string,
    public page?: any,
    public size?: number,
    public pageNo?: number
  ) {}
}
