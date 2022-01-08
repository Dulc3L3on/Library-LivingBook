import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-creaciones',
  templateUrl: './creaciones.component.html',
  styleUrls: ['./creaciones.component.css']
})
export class CreacionesComponent implements OnInit {
  fillAdd:string = '';
  cellOfOptions:string = '';

  constructor(private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
   
  }

  addNewBook():void{
    this.fillAdd = '-fill';
    this.router.navigate(['createABook'], {relativeTo: this.route});  
  }

  voidButtonAdd(){/*quizá sea mejor colocarlo en un service o hacer una llamada a un service aquí xD, en todo caso es mejor lo primero xD, ya veremos jsjsj */
    this.fillAdd = '';
  }

  showOtherOptions(laCelda:string){
    if(this.cellOfOptions != laCelda){      
      if(this.cellOfOptions != ''){
        document.getElementById(this.cellOfOptions)!.style.visibility = "hidden";
      }
      
      document.getElementById(laCelda)!.style.visibility = 'visible';
      console.log(document.getElementById(laCelda)!.firstChild);//esto demusetra como acceder al hijo, en todo caso lo que debes hacer es acceder a los hijos o a los nodos hijos, ambos contienen los elementos que dentro de ellos se encuentran...

      this.cellOfOptions = laCelda;

      console.log(this.cellOfOptions);
    }
    
  }

}
