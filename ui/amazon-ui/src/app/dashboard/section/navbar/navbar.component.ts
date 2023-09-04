import { Component } from '@angular/core';
import { faLocationDot } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  // brand image path
  logoPath: String = 'assets/amazon-logo-dark.png';

  faLocationDot = faLocationDot;
}
