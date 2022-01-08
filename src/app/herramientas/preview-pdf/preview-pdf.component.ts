import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-preview-pdf',
  templateUrl: './preview-pdf.component.html',
  styleUrls: ['./preview-pdf.component.css']
})
export class PreviewPDFComponent implements OnInit {
  pdfProcesado:any;

  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.pdfProcesado = this.route.snapshot.paramMap.get('pdfBlob');

    console.log(this.route.snapshot.paramMap.get('pdfBlob'));
    console.log(this.pdfProcesado);//ahora lo que tienes que ver es como recortar todo hasta que diga data y lo demás... xD :v


    //this.pdfProcesado = URL.createObjectURL(archivo);
  }

}
