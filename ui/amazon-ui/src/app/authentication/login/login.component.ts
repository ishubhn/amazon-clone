import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

import { faCaretDown, faCaretRight } from '@fortawesome/free-solid-svg-icons';
import { LoginUser } from 'src/app/interface/login-user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(
    private title: Title,
    private router: Router,
    private httpC: HttpClient
  ) {}

  ngOnInit(): void {
    this.title.setTitle('Amazon Sign In');
  }

  // image path
  logoPath: string = 'assets/amazon-logo-light.png';
  faCaretDown = faCaretDown;
  faCaretRight = faCaretRight;
  isFormSubmitted: boolean = false;
  isHelpClicked: boolean = false;

  // @V
  // loginForm: any;

  user: LoginUser = {
    userId: '',
    password: '',
  };

  // Functions
  onContinue() {
    this.isFormSubmitted = true;
  }

  onEditUserId() {
    this.isFormSubmitted = false;
  }

  onSubmit(form: NgForm) {
    this.user.userId = form.value.userId;
    this.user.password = form.value.password;
    console.log(this.user);
  }

  onClickCaret() {
    this.isHelpClicked = !this.isHelpClicked;
  }
}
