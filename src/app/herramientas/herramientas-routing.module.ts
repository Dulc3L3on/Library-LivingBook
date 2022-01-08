import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, Routes } from '@angular/router';
import { PreviewPDFComponent } from './preview-pdf/preview-pdf.component';
import { DescriptionOfBookComponent } from './description-of-book/description-of-book.component';

const routes:Routes = [
  {
    path: 'PreviewBook/:pdfBlob',/*quizá esté dando error porque se add aquí la dirección y por tanto no hay un "seguimiento del Router..." */
    component: PreviewPDFComponent,
  },
  {
    path: 'BookDescription',/*ahí le agregas el parámetro... */
    component: DescriptionOfBookComponent,
  }

];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports:[
    RouterModule,
  ]
})
export class HerramientasRoutingModule { }
