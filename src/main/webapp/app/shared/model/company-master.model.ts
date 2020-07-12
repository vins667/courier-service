export interface ICompanyMaster {
  id?: number;
  companyName?: string;
  address?: string;
  pinCode?: string;
  mdName?: string;
  mdContactNo?: string;
  mdEmailId?: string;
  panNumber?: string;
  webSiteUrl?: string;
  tinNumber?: string;
  gstNumber?: string;
  stateMasterStateName?: string;
  stateMasterId?: number;
  countryMasterCountryName?: string;
  countryMasterId?: number;
  cityMasterCityName?: string;
  cityMasterId?: number;
}

export class CompanyMaster implements ICompanyMaster {
  constructor(
    public id?: number,
    public companyName?: string,
    public address?: string,
    public pinCode?: string,
    public mdName?: string,
    public mdContactNo?: string,
    public mdEmailId?: string,
    public panNumber?: string,
    public webSiteUrl?: string,
    public tinNumber?: string,
    public gstNumber?: string,
    public stateMasterStateName?: string,
    public stateMasterId?: number,
    public countryMasterCountryName?: string,
    public countryMasterId?: number,
    public cityMasterCityName?: string,
    public cityMasterId?: number
  ) {}
}
