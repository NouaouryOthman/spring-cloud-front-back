import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {BillsComponent} from './components/bills/bills.component';
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {path: "bills", component: BillsComponent},
  {path: "", component: AppComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    BillsComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
