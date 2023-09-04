import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { FooterComponent } from './footer/footer.component';
import { RegisterVerifyComponent } from './register-verify/register-verify.component';



@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    RegisterVerifyComponent
  ],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule
  ]
})
export class AuthenticationModule { }
