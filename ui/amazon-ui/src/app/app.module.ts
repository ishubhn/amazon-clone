import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';

import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationModule } from './authentication/authentication.module';
import { AuthenticationRoutingModule } from './authentication/authentication-routing.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { DashboardModule } from './dashboard/dashboard.module';
import { DashboardRoutingModule } from './dashboard/dashboard-routing.module';

@NgModule({ declarations: [AppComponent],
    bootstrap: [AppComponent], imports: [BrowserModule,
        AppRoutingModule,
        AuthenticationModule,
        AuthenticationRoutingModule,
        DashboardModule,
        DashboardRoutingModule,
        FontAwesomeModule], providers: [Title, provideHttpClient(withInterceptorsFromDi())] })
export class AppModule {}
