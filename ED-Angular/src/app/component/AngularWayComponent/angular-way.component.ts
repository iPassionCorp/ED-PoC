import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

class Person {
  id: number;
  firstName: string;
  lastName: string;
}

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}

@Component({
  templateUrl: 'angular-way.component.html'
})

export class AngularWayComponent implements OnInit {
    dtOptions: DataTables.Settings = {};
    persons: Person[];
  
    constructor(private http: HttpClient) {}
  
    ngOnInit(): void {
      const that = this;
  
      this.dtOptions = {
        pagingType: 'full_numbers',
        pageLength: 5,
        serverSide: true,
        processing: true,
        info: false,
        searching: false,
        ajax: (dataTablesParameters: any, callback) => {
          that.http
            .post<DataTablesResponse>(
              'https://angular-datatables-demo-server.herokuapp.com/',
              dataTablesParameters, {}
            ).subscribe(resp => {
              that.persons = resp.data;
  
              callback({
                data: []
              });
            });
        },
        columns: [{ data: 'id' }, { data: 'firstName' }, { data: 'lastName' }]
      };
    }
}