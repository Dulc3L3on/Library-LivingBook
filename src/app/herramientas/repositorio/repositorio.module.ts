import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LibroComponent } from './libro/libro.component';
import { RepositorioComponent } from './repositorio.component';

@NgModule({
  declarations: [
    LibroComponent,
    RepositorioComponent,/*no olvides declarar cada componente en el modulo que le corresp, dep si tiene uno propio o no (como los compartidos) */
  ],
  imports: [
    CommonModule
  ],
  exports:[
    LibroComponent,/*no creo sea necesario invocarlo afuera de este componente...*/
    RepositorioComponent,
  ],
})
export class RepositorioModule { }
