import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BsDatepickerConfig, BsLocaleService } from 'ngx-bootstrap';
import { defineLocale } from 'ngx-bootstrap/chronos';
import { thLocale } from 'ngx-bootstrap/locale';
defineLocale('th', thLocale);

@Component({
    templateUrl: 'register-customer.html'
})

export class RegisterCustomer implements OnInit{
    constructor(private localeService: BsLocaleService){}
    ngOnInit(){
        this.localeService.use('th');
    }
}