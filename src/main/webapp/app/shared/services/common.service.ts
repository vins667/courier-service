import { Injectable } from '@angular/core';
import { ICode, Code } from '../model/code.model';

@Injectable({
  providedIn: 'root',
})
export class CommonService {
  locationWise: ICode[] = [new Code('C', 'City Wise'), new Code('Z', 'Zone Wise')];
  constructor() {}

  public getLocationWise(): ICode[] {
    return this.locationWise;
  }
}
