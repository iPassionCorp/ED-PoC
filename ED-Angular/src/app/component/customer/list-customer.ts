import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  templateUrl: 'list-customer.html'
})

export class ListCustomerComponent implements OnInit{
  private customers: any;
  private countCus: number;
  private p: number = 1;
  private pageSize: number = 5;
  private model: any = {};

  // sorting
  private key: string = 'name';
  private reverse: boolean = false;
  private sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://13.250.227.94:7001/ED-RestAPI/getAllCustomer').subscribe(data => {
      this.customers = data;
    });
  }

  private lengthChange(val: number){
    this.pageSize = val;
  }

  // search customer
  private submitSearchCustomer(){
    this.http.post('http://13.250.227.94:7001/ED-RestAPI/findCustomer', this.model).subscribe(data => {
      this.customers = data;
      this.countCus = this.customers.length;
    });
    console.log(this.model);
  }

}
