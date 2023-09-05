import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { faLocationDot, faMagnifyingGlass, faCaretDown, faCartShopping } from '@fortawesome/free-solid-svg-icons';
import { Address } from 'src/app/interface/address';
import { LoginUser } from 'src/app/interface/login-user';
import { User } from 'src/app/interface/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  // brand image path
  logoPath: String = 'assets/amazon-logo-dark.png';
  inFlagLogoPath: String = 'assets/in-flag-48.png';

  faLocationDot = faLocationDot;
  faSearch = faMagnifyingGlass;
  faCaretDown = faCaretDown;
  faCart = faCartShopping;
  isLoginSuccess: boolean = false;
  searchProduct: String = '';

  user: User = {
    firstName: '',
    lastName: '',
  };

  address: Address = {
    city: '',
    pinCode: '',
  };

  onSubmit = (form: NgForm) => {}
}
