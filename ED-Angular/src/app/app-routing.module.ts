import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListCustomerComponent } from './component/customer/list-customer';
import { RegisterCustomer } from './component/register-customer/register-customer';

const appRoutes: Routes = [
  { path: '', component: ListCustomerComponent },
  { path: 'register-customer', component: RegisterCustomer }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false
      }
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
