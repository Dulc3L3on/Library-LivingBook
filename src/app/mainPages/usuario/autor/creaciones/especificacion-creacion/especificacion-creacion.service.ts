import { Injectable } from '@angular/core';
import { ActivatedRoute, Router, RouterPreloader } from '@angular/router';

@Injectable()
export class EspecificacionCreacionService {

  constructor(private router:Router, private route:ActivatedRoute) { }


  hideWindow():void{   
    this.router.navigate(['MyProfile', 'creations']);//no lo logré con las cookies y con angular hay que usar evts... si te da tiempo mira una manera ás elegante, si no, de todos modos sé que esta raíz no cambiaría xD
    
  }

}
