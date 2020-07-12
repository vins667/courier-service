export interface IStateMaster {
  id?: number;
  code?: string;
  stateName?: string;
  countryMasterId?: number;
}

export class StateMaster implements IStateMaster {
  constructor(public id?: number, public code?: string, public stateName?: string, public countryMasterId?: number) {}
}
