import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register-verify',
  templateUrl: './register-verify.component.html',
  styleUrls: ['./register-verify.component.css']
})
export class RegisterVerifyComponent {
  constructor(
    private title: Title,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.title.setTitle('Amazon Phone Verification');
  }

  // image path
  logoPath: String = 'assets/amazon-logo-light.png';

  isFormSubmitted: boolean = false;
  userContactNumber: String = '';
  otp: String = '';

  onClickChange = () => {}

  onSubmit = (form: NgForm) => {}
}
