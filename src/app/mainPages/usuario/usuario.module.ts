import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioComponent } from './usuario.component';
import { AutorModule } from './autor/autor.module';
import { MiBibliotecaModule } from '../mi-biblioteca/mi-biblioteca.module';
import { UsuarioRoutingModule } from './usuario-routing.module';

@NgModule({
  declarations: [   
    UsuarioComponent,/*en realidad es el perfil */    
  ],
  imports: [
    CommonModule,
    UsuarioRoutingModule,
    MiBibliotecaModule,
    AutorModule,/*si es necesario lo exportas... */      
    //HerramientasModule,/*puesto que requiero de la previeew en miBiblioteca... me pregunto, si llefara a exportar este módulo, esto me premitiría que pudiera utilizarlo en los demás import??? */
  ],
  exports: [
    UsuarioComponent,
    /*UsuarioRoutingModule*//*no me dio problema al quitarlo después de haber compilado teniendo a esto exportado :v, pero por si xD */    
    /*AutorModule,*//*creo que había que exportarlo , sip :v, creo que es porque como contiene contenido para Routing, este aunque no se use más arriba, debe informarse de él a ellos, puesto que a partir de la raíz debe haber caminos para llegar a todas las rutas existentes...*/

    /*al parecer, con exportar 1 vez los módulos que contienen info para ROUTING, se completa el camino, por lo cual no es necesario mantener la exportación, puesto que media vez se completa 1 vez, a menos que se eli, se mantendrá la info... */
  ]
})
export class UsuarioModule { }
