export interface ICountryMaster {
  id?: number;
  code?: string;
  countryName?: string;
}

export class CountryMaster implements ICountryMaster {
  constructor(public id?: number, public code?: string, public countryName?: string) {}
}
