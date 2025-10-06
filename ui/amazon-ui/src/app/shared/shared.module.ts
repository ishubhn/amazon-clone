import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CatalogueCardComponent } from './catalogue-card/catalogue-card.component';

@NgModule({
  declarations: [CatalogueCardComponent],
  imports: [CommonModule],
  exports: [CatalogueCardComponent, CommonModule],
})
export class SharedModule {}
