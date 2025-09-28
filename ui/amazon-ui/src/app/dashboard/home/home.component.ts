import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Carousel } from 'src/app/interface/carousel';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private title: Title, private router: Router) {}

  ngOnInit(): void {
    this.title.setTitle('Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in');
  }

  carouselItems: Carousel[] = [
    {
      id: 1,
      filePath: 'assets/catalogue/carousel/product-1.jpg',
      searchCategory: 'greatIndianFestival',
      altText: "Great Indian Festival"
    },
    {
      id: 2,
      filePath: 'assets/catalogue/carousel/product-2.jpg',
      searchCategory: 'womenTradionals',
      altText: "Women Traditional Clothing"
    },
    {
      id: 3,
      filePath: 'assets/catalogue/carousel/product-3.jpg',
      searchCategory: 'lightBulbs',
      altText: "Electrical Bulbs"
    },
    {
      id: 4,
      filePath: 'assets/catalogue/carousel/product-4.jpg',
      searchCategory: 'headphones',
      altText: "Headphones"
    },
    {
      id: 5,
      filePath: 'assets/catalogue/carousel/product-5.jpg',
      searchCategory: 'mobileAccessories',
      altText: "Mobile Accessories"
    },
    {
      id: 6,
      filePath: 'assets/catalogue/carousel/product-6.jpg',
      searchCategory: 'teaCoffee',
      altText: "Tea and Coffee"
    },
    {
      id: 7,
      filePath: 'assets/catalogue/carousel/product-7.jpg',
      searchCategory: 'kitchenTools',
      altText: "Kitchen Tools"
    },
  ]
}
