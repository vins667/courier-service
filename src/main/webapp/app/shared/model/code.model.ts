export interface ICode {
  id?: number;
  desc?: string;
  code?: string;
}

export class Code implements ICode {
  constructor(public id: number, public code?: string, public desc?: string) {}
}
