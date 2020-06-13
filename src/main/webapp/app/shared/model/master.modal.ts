export interface IMaster {
  id?: string;
  desc?: string;
  name?: string;
  extract?: boolean;
  size?: number;
  pageNo?: number;
}

export class Master implements IMaster {
  constructor(public id?: string,
              public desc?: string,
              public name?: string,
              public extract?: boolean,
              public size?: number,
              public pageNo?: number) {
  }
}
