import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './section/navbar/navbar.component';
import { FooterComponent } from './section/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { NavbarBottomComponent } from './section/navbar-bottom/navbar-bottom.component';
import { AppRoutingModule } from "src/app/app-routing.module";
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    HomeComponent,
    NavbarBottomComponent,
    NavbarComponent,
    FooterComponent,
  ],
  imports: [
    AppRoutingModule,
    CommonModule,
    FontAwesomeModule,
    FormsModule,
    SharedModule
]
})
export class DashboardModule { }
