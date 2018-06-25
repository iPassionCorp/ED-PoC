import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PageChangedEvent } from 'ngx-bootstrap/pagination';

@Component({
  templateUrl: 'list-customer.html'
})

export class ListCustomerComponent implements OnInit{

  public customers: any;
  public p: number = 1;
  public pageSize: number = 5;
  
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://13.250.227.94:7001/ED-RestAPI/getAllCustomer').subscribe(data => {
      this.customers = data;
    });
  }

  private lengthChange(val: number){
    this.pageSize = val;
  }

}
