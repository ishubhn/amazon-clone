import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './section/navbar/navbar.component';
import { FooterComponent } from './section/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule
  ]
})
export class DashboardModule { }
