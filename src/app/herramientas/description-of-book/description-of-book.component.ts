import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-description-of-book',
  templateUrl: './description-of-book.component.html',
  styleUrls: ['./description-of-book.component.css']
})
export class DescriptionOfBookComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  navegarAPaginaAutor(){//debe estar en un servicio que pueda utilizarse en tienda (al ordenar por autor), perfil y descripción del producto
    this.router.navigate(['AutorProfile', 'idDelAutor']);//el componente será el mismo que el de perfil, se tendrá una var que revise si el header dice esto, que solo muestre los libros que el autor creó, de lo contrario, que mueste todo lo demás, aunque si quieres podrías hacer otro componente xD, practicamente será copy paste :v
  }

  changeStateLike():void{
    //se cambiará el estado de la variable que recibe el valor de la base de datos, recuerda que se guardaron números...
    //tb se cambiará a fill el estado del corazoncito, no se contarán los click, lo que se hará es colocar el otro valor a la variable (1 o 0, fill o ''), ahí miras cual de las dos resulta mejor revisar xD
  }

}
