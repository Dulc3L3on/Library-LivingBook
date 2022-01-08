import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NoticiaComponent } from './noticia/noticia.component';


@NgModule({
  declarations: [
    NoticiaComponent
  ],
  imports: [
    CommonModule
  ],  
  exports:[
    /*así como sucedió con el módulo de usuerio, se tenía que exportar puesto que este modulo de noticias, se exporta en otro... solo que aquí no funcionó después de eli la exportación como en el caso del módulo de usuario [que es eqq a este de noticias xD]... 
      Ahora creo que en ningún momento el error fue por no tener este export, sino porque estaba exportando el componente Noticia en el módulo de MainPages, cuando en todo caso, eso tendría que hacerse aquí xD, puesto que aquí se declaró xD    */
  ]
})
export class NoticiasModule { }
