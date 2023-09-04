import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUser } from '../interface/login-user';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private httpc: HttpClient) {}

  loginUser = (user: LoginUser) => {
    console.log("inside service");

    console.log(user);

    return this.httpc
      .post<boolean>(`${environment.restServiceURL}/auth/login`, user);
  };
}
