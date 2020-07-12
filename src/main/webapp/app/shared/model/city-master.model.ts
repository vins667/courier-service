export interface ICityMaster {
  id?: number;
  code?: string;
  cityName?: string;
  pinCode?: string;
  stateMasterStateName?: string;
  stateMasterId?: number;
  cityMasters?: ICityMaster[];
}

export class CityMaster implements ICityMaster {
  constructor(
    public id?: number,
    public code?: string,
    public cityName?: string,
    public pinCode?: string,
    public stateMasterStateName?: string,
    public stateMasterId?: number,
    public cityMasters?: ICityMaster[]
  ) {}
}
