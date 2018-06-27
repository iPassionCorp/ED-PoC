import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
declare var jquery:any;
declare var $ :any;

@Component({
    templateUrl: 'register-customer.html'
})

export class RegisterCustomer implements OnInit{
    private getReceiver: any;
    private getCustomerType: any;
    constructor(private http: HttpClient){}
    ngOnInit(){
        // getReceiver
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getReceiver').subscribe(data => {
            this.getReceiver = data;
        });

        // getCustomerType
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getCustomerType').subscribe(data => {
            this.getCustomerType = data;
        });

        $(document).ready(function () {
            $('.datepicker').datepicker({
                format: 'dd/mm/yyyy',
                language: 'th',
                thaiyear: true,
                orientation: 'bottom',
                autoclose: true,
                todayHighlight: true
            });
            $('.mask-cardId').inputmask('9-9999-99999-99-9');
            $('.select2').select2({width: '100%'});
        });
    }
}