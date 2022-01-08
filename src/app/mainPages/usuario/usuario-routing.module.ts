import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, Routes } from '@angular/router';
import { MiBibliotecaComponent } from '../mi-biblioteca/mi-biblioteca.component';
import { CreacionesComponent } from './autor/creaciones/creaciones.component';
import { EstadisticasComponent } from './autor/estadisticas/estadisticas.component';
import { UsuarioComponent } from './usuario.component';
import { EspecificacionCreacionComponent } from './autor/creaciones/especificacion-creacion/especificacion-creacion.component';

const routes: Routes =  [
  {
    path: 'MyProfile',
    component: UsuarioComponent,/*que se quede aquí aunque no esté declarado en el módulo de las mainPages por problemas de importaciones xD, si quieres que esté en el conjunto que debiera, puedes importar el módulo y exportarlo, aunque pienso que eso daría problemas, puesto que tiene imports repetidos... */
    children:[
      {
        path: 'myLibrary',
        component: MiBibliotecaComponent,
      },    
      {
        path: 'creations',
        component: CreacionesComponent,
        children:[
          {
            path: 'createABook',
            component: EspecificacionCreacionComponent,              
          } 
        ]
      },  
      {
        path: 'statistics',
        component: EstadisticasComponent,
      }
    ],    
  }, 
  
];

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
export class UsuarioRoutingModule { }
