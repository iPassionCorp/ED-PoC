import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListCustomerComponent } from './component/customer/list-customer';
import { AngularWayComponent } from './component/AngularWayComponent/angular-way.component';

const appRoutes: Routes = [
  { path: '', component: ListCustomerComponent },
  { path: 'test', component: AngularWayComponent }
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
