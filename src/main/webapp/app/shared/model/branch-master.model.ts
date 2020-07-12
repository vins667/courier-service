export interface IBranchMaster {
  id?: number;
  branchName?: string;
  managerName?: string;
  pinCode?: string;
  address?: string;
  email?: string;
  mobile?: string;
  stateMasterId?: number;
  cityMasterId?: number;
  companyMasterCompanyName?: string;
  companyMasterId?: number;
  countryMasterCountryName?: string;
  countryMasterId?: number;
}

export class BranchMaster implements IBranchMaster {
  constructor(
    public id?: number,
    public branchName?: string,
    public managerName?: string,
    public pinCode?: string,
    public address?: string,
    public email?: string,
    public mobile?: string,
    stateMasterId?: number,
    cityMasterId?: number,
    public companyMasterCompanyName?: string,
    public companyMasterId?: number,
    public countryMasterCountryName?: string,
    public countryMasterId?: number
  ) {}
}
