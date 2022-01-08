import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TiendaComponent } from './tienda/tienda.component';
import { ConfiguracionComponent } from './configuracion/configuracion.component';
import { MainPagesRoutingModule } from './main-pages-routing.module';
import { HerramientasModule } from '../herramientas/herramientas.module';
import { UsuarioModule } from './usuario/usuario.module';/*se eliminó porque pienso que provocaría problemas, debido a que importa un mismo módulo en los módulos de los comp que utiliza, el cual también se importa aquí... */
import { NoticiasModule } from './noticias/noticias.module';

@NgModule({
  declarations: [
    TiendaComponent,       
    ConfiguracionComponent,    
   /*solamente los componentes que estén DECLARADOS son capaces de utilizar lo que esté importado, lo cual también es equivalente a que los import NO PUEDEN utilizar nada de lo que esté declarado...*/  
  ],
  imports: [
    CommonModule,
    MainPagesRoutingModule,
    HerramientasModule,  /*por el momento solo lo utiliza tienda, si sique así, entonces haz la importación en el módulo de esta e importa y exporta a Usuario. El único que quizá podría necesitarlo más adelante, sería Noticias...*/
    UsuarioModule,
    NoticiasModule/*da error porque dice que noticiaComponent nunca ha sido declarado o importado, pero sí está declarado :p, se supone que solo se debe exportar si será utilizado en otro lado, pero se arregló exportando el componente (Noticia) :v */
  ],
  exports:[
    TiendaComponent,        
    ConfiguracionComponent,  
    UsuarioModule,
    NoticiasModule
  ]
})
export class MainPagesModule { }
