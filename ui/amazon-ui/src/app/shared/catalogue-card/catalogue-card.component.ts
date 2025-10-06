import { Component, Input } from '@angular/core';
import { CatalogueItem } from 'src/app/interface/catalogue-item';
import { LinkText } from 'src/app/interface/link-text';

@Component({
  selector: 'catalogue-card',
  templateUrl: './catalogue-card.component.html',
  styleUrl: './catalogue-card.component.css',
})
export class CatalogueCardComponent {
  @Input()
  cardHeader: String = '';
  
  @Input() 
  items: CatalogueItem[] = [];

  @Input()
  linkText?: LinkText;

  get chunkedItems() {
    const chunkSize = 2;
    const chunks = [];

    for (let i = 0; i < this.items.length; i += chunkSize) {
      // Slice from i to i+chunkSize
      chunks.push(this.items.slice(i, i + chunkSize));
    }

    return chunks;
  }

  /*
    // chatGpt code
    get chunkedItems() {
      const chunkSize = 2;
      return Array.from(
        { length: Math.ceil(this.items.length / chunkSize) },
        (_, i) => this.items.slice(i * chunkSize, i * chunkSize + chunkSize)
      );
    }
  */

  get displayLink() {
    return this.linkText?.text || 'Explore All';
  }

  get linkHref() {
    return this.linkText?.linkSrc || '#';
  }
}
