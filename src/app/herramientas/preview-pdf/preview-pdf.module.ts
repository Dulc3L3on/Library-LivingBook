import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PreviewPDFComponent } from './preview-pdf.component';
import { PreviewPdfService } from './preview-pdf.service';

@NgModule({
  declarations: [
    PreviewPDFComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    PreviewPDFComponent,
  ],
  providers:[
    PreviewPdfService,
  ]
  
})
export class PreviewPdfModule { }
