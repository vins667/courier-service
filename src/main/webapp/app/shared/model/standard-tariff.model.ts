export interface IStandardTariff {
  id?: number;
  fromWeight?: number;
  toWeight?: number;
  dox?: string;
  nDox?: string;
  networkMasterNetworkName?: string;
  networkMasterId?: number;
  serviceMasterServiceName?: string;
  serviceMasterId?: number;
  cityMasterCityName?: string;
  cityMasterId?: number;
  locationWiseCityName?: string;
  locationWiseId?: number;
  locationWise?: string;
  location?: number;
}

export class StandardTariff implements IStandardTariff {
  constructor(
    public id?: number,
    public fromWeight?: number,
    public toWeight?: number,
    public dox?: string,
    public nDox?: string,
    public networkMasterNetworkName?: string,
    public networkMasterId?: number,
    public serviceMasterServiceName?: string,
    public serviceMasterId?: number,
    public cityMasterCityName?: string,
    public cityMasterId?: number,
    public locationWiseCityName?: string,
    public locationWiseId?: number,
    locationWise?: string,
    location?: number
  ) {}
}
