import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationModule } from './authentication/authentication.module';
import { AuthenticationRoutingModule } from './authentication/authentication-routing.module.ts.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
    AuthenticationRoutingModule,
    HttpClientModule,
    FontAwesomeModule,
  ],
  providers: [Title],
  bootstrap: [AppComponent],
})
export class AppModule {}
