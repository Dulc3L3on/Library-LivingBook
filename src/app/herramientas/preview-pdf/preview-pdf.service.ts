import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable()
export class PreviewPdfService {
  file:any;//quizá más adelante podría ser útil...
  pdfProcesado:any;

  constructor(private router:Router, private route:ActivatedRoute) { }

  setFile(file:File){
    this.file = file;
  }

  createPreview(){
    this.pdfProcesado = URL.createObjectURL(this.file);//crea un blob, creo que será útil para guardar los arch en la DB, para así poder recuperarlos...

    console.log(this.pdfProcesado);    
    console.log('ruta del padre? \n1. ' + this.route.pathFromRoot +"\n2. " + this.route + "\n3. " + this.route.url);

    //this.router.navigate(['PreviewBook', pdfCodificado]);//si no llegara a funcionar por el hecho de que envía un string, entonces o bien haces la conversion en el ngOnInit o empleas un seter del componente...
    window.open(this.route.toString()+"/"+this.pdfProcesado, "_blank");
  }
}
