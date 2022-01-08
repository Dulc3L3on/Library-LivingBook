import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filtro',
  templateUrl: './filtro.component.html',
  styleUrls: ['./filtro.component.css']
})
export class FiltroComponent implements OnInit {
  areSearchABook:boolean = true;
  isFilterThatDate:boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  changeTypeOfSearch(){
    this.areSearchABook = !this.areSearchABook;
    this.isFilterThatDate = true;//debe estar, ya sea que emplees la forma con JQuery o el envío del estado por medio de paráms...
  }

  changeTypeOfSearch_Date(){
    this.isFilterThatDate = (document.querySelector('input[id = "radioOfDate"]:checked')!=null);
    
    //this.isFilterThatDate = mostrar;//tener esta línea y un parámetro en el método para que cada botón enviase true o false dependiendo de si era o no el que corresp a la fecha y cambiar la variable a true cuando el tipo de búsqueda (autor o libro) cambiara (lo cual se mantiene con este método), hace exactamente lo mismo que al usar querySelector
  }

}
