import { isDevMode, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: !isDevMode() })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
