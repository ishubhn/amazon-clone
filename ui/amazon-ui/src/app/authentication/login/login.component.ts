import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

import { faCaretDown, faCaretRight } from '@fortawesome/free-solid-svg-icons';
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
  isFormSubmitted: boolean = false;
  isHelpClicked: boolean = false;

  user: LoginUser = {
    userId: '',
    password: '',
  };

  // Functions
  onContinue() {
    this.isFormSubmitted = true;
    console.log(this.user.userId);
  }

  onEditUserId() {
    this.isFormSubmitted = false;
  }

  onClickCaret() {
    this.isHelpClicked = !this.isHelpClicked;
  }

  onSubmit(form: NgForm) {
    console.log("login process");
    console.log(this.user);

    this.authService.loginUser(this.user).subscribe(
      (res) => {
        console.log(`Login successful for user: ${this.user.userId}`);
      },
      (err) => {
        console.error(err);
      }
    )
  }
}
