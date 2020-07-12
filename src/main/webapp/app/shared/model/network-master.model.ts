export interface INetworkMaster {
  id?: number;
  networkCode?: string;
  networkName?: string;
  contactPerson?: string;
  contactNumber?: string;
  address?: string;
  website?: string;
  email?: string;
  cityMasterCityName?: string;
  cityMasterId?: number;
}

export class NetworkMaster implements INetworkMaster {
  constructor(
    public id?: number,
    public networkCode?: string,
    public networkName?: string,
    public contactPerson?: string,
    public contactNumber?: string,
    public address?: string,
    public website?: string,
    public email?: string,
    public cityMasterCityName?: string,
    public cityMasterId?: number
  ) {}
}
