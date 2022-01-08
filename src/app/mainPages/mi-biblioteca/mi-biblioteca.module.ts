import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MiBibliotecaComponent } from './mi-biblioteca.component';
import { MiBibliotecaService } from './mi-biblioteca.service';
import { HerramientasModule } from 'src/app/herramientas/herramientas.module';


@NgModule({
  declarations: [
    MiBibliotecaComponent,/*pensaba declaralo en el módulo de usaurios para importar allá el módulo de herramientas, pero al hacer eso tendría que declarar el componente de la carpeta autor, que utilizará (o eso planeo xD) la barra de búsqueda y así se desordenarían las cosas, entonces no xD */
  ],
  imports: [
    CommonModule,
    HerramientasModule
  ],
  exports:[
    MiBibliotecaComponent
  ],
  providers:[
    MiBibliotecaService
  ]
})
export class MiBibliotecaModule { }
