import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  selectedButton:string = 'myLibrary';

  constructor(private router:Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  navigateTO(tipoOpcion:string):void{
    this.router.navigate([tipoOpcion], {relativeTo: this.route});

    if(this.selectedButton != tipoOpcion){
      document.getElementById(this.selectedButton)!.classList.remove('markup');
      document.getElementById(tipoOpcion)!.classList.add('markup');

      this.selectedButton = tipoOpcion;
      //otra forma de hacer esto es creando un arreglo de 3 espacios para add markup en el espacio que corresp al botón clickeado, el cual sabrás cual es debido a que el 
      //índice corresp se enviaría por medio de un parámetro con el método, pero antes de hacer esa asignación, deberías "limpiar" el arreglo para no tener más de uno con 
      //ese valor para la clase... [simi a lo que hiciste con elBilletón con JSP's]
    }
  }

}
