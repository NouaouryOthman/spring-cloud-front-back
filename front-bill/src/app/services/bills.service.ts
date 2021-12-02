import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BillsService {

  private host = environment.hostname;

  constructor(private httpClient: HttpClient) {
  }

  public getBills() {
    return this.httpClient.get(this.host + "/bills");
  }

  public getFullBill(id: number) {
    return this.httpClient.get(this.host + "/fullBill/" + id);
  }
}
