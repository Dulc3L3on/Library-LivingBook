import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreacionesComponent } from './creaciones.component';
import { EspecificacionCreacionComponent } from './especificacion-creacion/especificacion-creacion.component';
import { CreacionesRoutingModule } from './creaciones-routing.module';
import { EspecificacionCreacionService } from './especificacion-creacion/especificacion-creacion.service';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    CreacionesComponent,
    EspecificacionCreacionComponent
  ],
  imports: [
    CommonModule,
    CreacionesRoutingModule,
    ReactiveFormsModule
  ],
  exports:[
    CreacionesComponent,
    EspecificacionCreacionComponent,
    CreacionesRoutingModule
  ],
  providers:[
    EspecificacionCreacionService
  ]
})
export class CreaciononesModule { }
