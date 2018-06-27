import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './component/navbar/navbar.component';
import { FooterComponent } from './component/footer/footer.component';
import { ListCustomerComponent } from './component/customer/list-customer';
import { FormsModule } from '@angular/forms';
import { CollapseModule, BsDatepickerModule } from 'ngx-bootstrap';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { NumberOnlyDirective } from './directives/number.directive';
import { DataTablesModule } from 'angular-datatables';
import { AngularWayComponent } from './component/AngularWayComponent/angular-way.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ListCustomerComponent,
    NumberOnlyDirective,
    AngularWayComponent
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
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
