import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './component/navbar/navbar.component';
import { FooterComponent } from './component/footer/footer.component';
import { ListCustomerComponent } from './component/customer/list-customer';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CollapseModule, TabsModule, ModalModule, BsDatepickerModule } from 'ngx-bootstrap';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { NumberOnlyDirective } from './directives/number.directive';
import { RegisterCustomer } from './component/register-customer/register-customer';

import { defineLocale } from 'ngx-bootstrap/chronos';
import { deLocale } from 'ngx-bootstrap/locale';
defineLocale('th', deLocale);
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ListCustomerComponent,
    NumberOnlyDirective,
    RegisterCustomer
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CollapseModule.forRoot(),
    NgxPaginationModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    TabsModule.forRoot(),
    ReactiveFormsModule,
    ModalModule.forRoot(),
    BsDatepickerModule.forRoot()
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
