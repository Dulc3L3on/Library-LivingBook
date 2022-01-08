import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FiltroComponent } from './filtro/filtro.component';
import { BarraBusquedaComponent } from './barra-busqueda.component';

@NgModule({
  declarations: [
    BarraBusquedaComponent,
    FiltroComponent,   
  ],
  imports: [
    CommonModule
  ],
  exports:[
    BarraBusquedaComponent,  /*no exporto fltro porque este solo se utilizará dentro de la barra de búsquedas */
  ],
})
export class BarraBusquedaModule { }
