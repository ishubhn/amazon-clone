import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { faCaretRight, faInfo } from '@fortawesome/free-solid-svg-icons';
import { RegisterUser } from 'src/app/interface/register-user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  constructor(
    private title: Title,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.title.setTitle('Amazon Registration');
  }

  // image path
  logoPath: string = 'assets/amazon-logo-light.png';
  faCaretRight = faCaretRight;
  faInfo = faInfo;

  isFormSubmitted: boolean = false;
  isUserRegistrationSuccess: boolean = true;

  userName = {
    name: ''
  }

  user: RegisterUser = {
    firstName: '',
    lastName: '',
    contactNumber: '',
    emailId: '',
    password: '',
  };

  onSubmit(form: NgForm) {}
}
