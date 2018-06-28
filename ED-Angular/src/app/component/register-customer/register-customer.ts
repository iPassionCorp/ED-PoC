import { Component, OnInit, TemplateRef, OnDestroy } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { BsLocaleService, listLocales } from 'ngx-bootstrap';
declare let jquery:any;
declare let $ :any;
declare let swal: any;


@Component({
    templateUrl: 'register-customer.html'
})

export class RegisterCustomer implements OnInit{
    locale = 'th';
    locales = listLocales();
    getReceiver: any;
    getCustomerType: any;
    getAllPrePostFix: any;
    getPrefix: string = '';
    registerForm: FormGroup;
    submitted = false;
    modalRef: BsModalRef;
    changeRecriveDate: string;
    concatAddress: any;
    concatFullName: any;
    checkFormArr: boolean = false;
    getCategories: any;
    getSubProducts: any;
    selection = [];

    arrTax = new FormArray([]);
    constructor(
        private http: HttpClient,
        private formBuilder: FormBuilder,
        private modalService: BsModalService,
        private localeService: BsLocaleService
    ){}
    ngOnInit(){
        // getReceiver
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getReceiver').subscribe(data => {
            this.getReceiver = data;
        });

        // getCustomerType
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getCustomerType').subscribe(data => {
            this.getCustomerType = data;
        });

        // getAllPrePostFix
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getAllPrePostFix').subscribe(data => {
            this.getAllPrePostFix = data;
        });

        // get ccategories
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getCategories').subscribe(data => {
            this.getCategories = data;
        });

        this.registerForm = this.formBuilder.group({
            cusId: [Math.floor(Math.random() * 1000000) + 1],
            address: [''],
            cardId: ['', Validators.required],
            fullName: [''],
            firstName: ['', Validators.required],
            lastName: [''],
            ppPrefix: [''],
            ppPostfix: [''],
            houseNo: [''],
            office: [''],
            district: ['', Validators.required],
            district2: ['', Validators.required],
            province: ['', Validators.required],
            postcode: ['', Validators.required],
            phone: ['', Validators.required],
            email: [''],
            receiveid: ['', Validators.required],
            receivedate: ['', Validators.required],
            receiver:['', Validators.required],
            ctypeId:['', Validators.required],
            building: [''],
            roomNo: [''],
            floor: [''],
            moo: [''],
            soi: [''],
            road: [''],
            titleName2: [''],
            firstName2: [''],
            lastName2: [''],
            cardId2: [''],
            taxType: ['01', Validators.required],
            products: this.formBuilder.array([this.initProducts()])
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

    get f() { return this.registerForm.controls; }

    initProducts(){
        return this.formBuilder.group({
            categories: [''],
            taxDate: [''],
            tax: ['']
        });
    }

    addNewRow(){
        this.checkFormArr = true;
        const control = <FormArray>this.registerForm.controls.products;
        if(this.checkFormArr === true){
            control.push(this.initProducts());
        }

    }

    deleteRow(index: number){
        const control = <FormArray>this.registerForm.controls.products;
        control.removeAt(index);
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getProductByCatId?gpId=').subscribe(data => {
            this.getSubProducts = data;
        });
    }

    onChangeTitleName(val: number){
        if(val === 1){
            setTimeout(() => {
                this.registerForm.value.ppPrefix = 'นาย';
            }, 20);
        } else if(val === 2){
            setTimeout(() => {
                this.registerForm.value.ppPrefix = 'นางสาว';
            }, 20);
        } else{
            setTimeout(() => {
                this.registerForm.value.ppPrefix = 'บริษัท';
                this.registerForm.value.ppPostfix = 'จำกัด';
            }, 20);
        }
    }

    onSubmit() {
        this.submitted = true;
        this.concatAddress = this.registerForm.value.houseNo+' '+this.registerForm.value.office+' ตำบล/แขวง '+ this.registerForm.value.district+' อำเภอ/เขต '+this.registerForm.value.district2+' จังหวัด '+this.registerForm.value.province+' รหัสไปรษณีย์ '+this.registerForm.value.postcode;
        this.concatFullName = this.registerForm.value.ppPrefix+' '+this.registerForm.value.firstName+' '+this.registerForm.value.lastName+' '+this.registerForm.value.ppPostfix;
        const httpOptions = {
              headers: new HttpHeaders({
                'Content-Type':  'application/json'
              })
        };
        let params = {
            "customer" : {
                cusId: this.registerForm.value.cusId,
                address:  this.concatAddress,
                cardId: this.registerForm.value.cardId,
                fullName: this.concatFullName,
                phone: this.registerForm.value.phone,
                email: this.registerForm.value.email,
                receiveid : this.registerForm.value.receiveid,
                receivedate: "29/06/2561",
                receiver : this.registerForm.value.receiver
            },
            products: []
        };
        if (this.registerForm.invalid) {
            return;
        } 
        this.http.post('http://13.250.227.94:7001/ED-RestAPI/register',
            params, httpOptions).subscribe(suc => {
                swal({
                    type: 'success',
                    title: 'บันทึกเรียบร้อย',
                    showConfirmButton: false,
                    timer: 2000
                  });
                  setTimeout(() => {
                    window.location.href = "http://localhost:4200"
                  }, 3000);
                console.log(JSON.stringify(this.registerForm.value));
            },
            err => {
                swal({
                    type: 'error',
                    title: 'ไม่สามารถบันทึกได้',
                    showConfirmButton: false,
                    timer: 2000
                  });
                console.log(err);
        });
    }

    openModal(template: TemplateRef<any>) {
        this.modalRef = this.modalService.show(template);
    }

    resetSmForm(){
        setTimeout(() => {
            this.registerForm.controls.titleName2.reset();
            this.registerForm.controls.firstName2.reset();
            this.registerForm.controls.lastName2.reset();
            this.registerForm.controls.cardId2.reset();
        }, 20);
    }

    getProducts(val: any, index: number){
        this.selection[index] = val;
        // getProduct
        this.http.get('http://13.250.227.94:7001/ED-RestAPI/DDL/getProductByCatId?gpId=' + val).subscribe(data => {
            this.getSubProducts = data;
        });
    }
}