import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-barra-busqueda',
  templateUrl: './barra-busqueda.component.html',
  styleUrls: ['./barra-busqueda.component.css']
})
export class BarraBusquedaComponent implements OnInit {
  showFilter:boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  changeStateOfShowingFilter():void{
    this.showFilter = !this.showFilter;
  }

}