import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

import { faCaretDown, faCaretRight, faInfo } from '@fortawesome/free-solid-svg-icons';
import { LoginUser } from 'src/app/interface/login-user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(
    private title: Title,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.title.setTitle('Amazon Sign In');
  }

  // image path
  logoPath: string = 'assets/amazon-logo-light.png';
  faCaretDown = faCaretDown;
  faCaretRight = faCaretRight;
  faInfo = faInfo;
  isFormSubmitted: boolean = false;
  isHelpClicked: boolean = false;
  isUserLoginSuccess: boolean = true;

  user: LoginUser = {
    identifier: '',
    password: '',
  };

  // Functions
  onContinue() {
    this.isFormSubmitted = true;
    console.log(this.user.identifier);
  }

  onEditUserId() {
    this.isFormSubmitted = false;
  }

  onClickCaret() {
    this.isHelpClicked = !this.isHelpClicked;
  }

  onSubmit(form: NgForm) {
    console.log("login process started");
    // console.log(this.user);

    this.authService.loginUser(this.user).subscribe(
      res => {
        console.log(res);
        console.log("User logged in successfully");
        console.log(this.user);
      },
      err => {
				console.error("Invalid Credentials");
        console.log(this.user);
				console.log(err.error.message);
				this.isUserLoginSuccess = false;
      }
    );
    // this.form.reset();
  }
}
