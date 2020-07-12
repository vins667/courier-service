export interface IServiceMaster {
  id?: number;
  serviceCode?: string;
  serviceName?: string;
  dimensioncharge?: number;
}

export class ServiceMaster implements IServiceMaster {
  constructor(public id?: number, public serviceCode?: string, public serviceName?: string, public dimensioncharge?: number) {}
}
