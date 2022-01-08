import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, Routes } from '@angular/router';
import { CreacionesComponent } from './creaciones.component';
import { EspecificacionCreacionComponent } from './especificacion-creacion/especificacion-creacion.component';

const routes:Routes = [
 /*creo que tendrás que eliminar este módulo :v */
           
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports:[
    RouterModule,
  ]
})
export class CreacionesRoutingModule { }
