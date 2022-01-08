import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { ConnectableObservable, Observable, Subscriber } from 'rxjs';
import { EspecificacionCreacionService } from './especificacion-creacion.service';

@Component({
  selector: 'app-especificacion-creacion',
  templateUrl: './especificacion-creacion.component.html',
  styleUrls: ['./especificacion-creacion.component.css']
})
export class EspecificacionCreacionComponent implements OnInit { 
  fileUpLoad:any;//quizá sea mejor tener una global, así no está creando cada uvez una var... eso sí tendrá el arch del elemento al que hayan dado click más recientemente...  
  pdfProcesado:SafeResourceUrl|null = null;

  constructor(private router:Router, private sanitizer:DomSanitizer,private servicioAddLibro:EspecificacionCreacionService) { }

  creacionForm = new FormGroup({
    //por lo que vi, T manejó esto por aparte, solo datos "normales" incluyó en el form, deplano que será porque los archivos se "recuperan" diferente, es decir: al change el input file, entonces no hay que tener un control para obtener el valor, porque esto se hace al suceder cierto evt... y cuando se requiera enviar la info (luego de que presionó submit), solo se debe enviar tb la(S) var que se encargaron de recopilar la info del archivo junto con los valores de los demás controles, en el método para hacer submit()
  
    

  });

  ngOnInit(): void {
    console.log('me creo');
  }

  hideMe():void{ 
    this.servicioAddLibro.hideWindow();
  }


  //esto se irá a un servicio propio del input file para cargar imágenes... creo que habrá otro para PDF's...
  spreadOutClickImage(){
    const fileUpLoad = document.getElementById('fileButton') as HTMLInputElement;//esto último especifica el tipo...

    fileUpLoad.onchange =  ()  => { 
      if(this.reviewSuportedImages(fileUpLoad.files![0].type)){
        //this.createPreview(fileUpLoad.files![0].name);
        this.createPreview(fileUpLoad.files![0]);//DEBE invocarse como regla, cuando el filInput cambie ONCHANGE!
        
      }else{
        //Se activa el sweet, creo que en este caso será por medio del cb del valor de una variable para activar un template, o quizá se pueda llamar directamente xD, quizá (mira como lo imple Thony, si es que no te sale xD)
      }
    }

    fileUpLoad.click();   
  }

  reviewSuportedImages(extension:string):boolean{
    const tiposSoportados:string[] =['image/jpeg', 'image/jpg', 'image/png'];
    var tipoActual:number = 0;

    for(tipoActual;tipoActual < tiposSoportados.length; tipoActual++){
      if(extension != tiposSoportados[tipoActual] && tipoActual == 2){
        return false;
      }
    }

    return true;
  }

  createPreview(file:File){
    var imagenCodificada = URL.createObjectURL(file);//crea un blob, creo que será útil para guardar los arch en la DB, para así poder recuperarlos...

    console.log(imagenCodificada);    
    const imagen = document.getElementById('photoPreview') as HTMLImageElement;
    imagen.src= imagenCodificada;    
  }

  spreadOutClickPDF():void{
    this.fileUpLoad = document.getElementById('pdfButton') as HTMLInputElement;
    const inputText = document.getElementById('nameOfPDF') as HTMLInputElement;

    this.fileUpLoad.onchange =  ()  => { 
      console.log(this.fileUpLoad.files![0].type);

      if('application/pdf' == this.fileUpLoad.files![0].type){
        //se agrega el listener para que pueda ver la previsualización, sino, se eliminará el evt click, de no ser null...
        
        inputText.value = this.fileUpLoad.files![0].name;        
        //inputText.addEventListener("click", this.callPreviewService);                
        document.getElementById('cellToSee')!.style.display = '';
      }else{
        //Se activa el sweet
        inputText.value = '';//para que se muestre el placeholder        
        //inputText.removeEventListener("click", this.callPreviewService);//no pasa nada malo si no tiene un evento del tipo que se desea eliminar...
        document.getElementById('cellToSee')!.style.display = 'none';
      }
    }

    this.fileUpLoad.click();   
  }

 /* callPreviewService():void{
    console.log(this.servicioPreviewPDF);

    this.servicioPreviewPDF.setFile(this.fileUpLoad.files![0]);
    this.servicioPreviewPDF.createPreview();    

    console.log('error con definición del servicio...');
  }*/

  /*showAPreview(){
    /*this.pdfProcesado = URL.createObjectURL(this.fileUpLoad.files![0]);
    console.log(this.pdfProcesado);        

    //window.open("http://localhost:4200/PreviewBook/"+this.pdfProcesado, "_blank");

    window.open("http://localhost:4200/PreviewBook/"+this.fileUpLoad.files![0], "_blank");
  }*/

  //ahora pienso que la solución, sería enviar un base64 como parám y que este sea tomado en el componente para previsualizar... puesto que los iframe tb entienden base64...

  //convertToBase64() {//JSjsj lo haremos con JAVA :v, es por mucho más fácil :v :v :v, entonces lo que se hará es convertir a base 64 y luego navegar con el window open hasta el componente PreviewBook con el string en esa base agrgado y con el OnInit del componente tal y como está, e decir que extrae el contenido xD y allá mismo le aplicará el byPass...
    //RECUERDA, tanto el pdf como la imagen, se pasarán a base 64 antes de ser almacenadas en la DB, ya sea de una vez en el método del submit o enviando el file y haciendo la conversiónen java xD


  /*  const pdf = new Observable((subscriber: Subscriber<any>) => {
      this.readFile(this.fileUpLoad.files![0], subscriber);
    });

    this.pdfProcesado = this.sanitizer.bypassSecurityTrustResourceUrl(pdfProcesado);*/
  //}

  /*readFile(file: File, subscriber: Subscriber<any>) {
    const filereader = new FileReader();
    filereader.readAsDataURL(file);

    filereader.onload = () => {
      subscriber.next(filereader.result);
      subscriber.complete();
    };
    filereader.onerror = (error) => {
      subscriber.error(error);
      subscriber.complete();
    };
  }*/

  convertToBase64():void{
    var reader = new FileReader();   
    var url:any;

    reader.onloadend = () => {
      console.log("sucedo después");
      console.log("el resultado del reader-> "+reader.result);

      //window.open("data:application/octet-stream;base64," + url);
      url = reader.result;
      console.log("la url -> "+url);
      this.pdfProcesado = this.sanitizer.bypassSecurityTrustResourceUrl(url!); 
  
      window.open("http://localhost:4200/PreviewBook/"+this.pdfProcesado, "_blank");
      console.log("el pdf sanitizado -> "+this.pdfProcesado);//sin usar el [src] me da el error de no seguro a pesar de tener el sanitizador, y al usar el [src] y el getter, me dice que no existe una url para eso, mira como hizo Marcos para mostrarlo :v      
            
    };

    console.log("sucedo antes");
    reader.readAsDataURL(this.fileUpLoad.files![0]);
    

  }

}
