import {Component, OnInit} from '@angular/core';
import {BillsService} from "../../services/bills.service";
import {catchError, map, of, startWith} from "rxjs";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {
  public bills: any;
  public fullBill: any;

  constructor(public billsService: BillsService) {
  }

  ngOnInit(): void {
    this.billsService.getBills()
      .subscribe(data => {
        this.bills = data
      }, error => {
        console.log(error)
      });
  }

  onGetBill(id: number) {
    console.log("here" + id);
    this.billsService.getFullBill(id)
      .subscribe(data => {
        this.fullBill = data
      }, error => {
        console.log(error)
      });
  }
}
