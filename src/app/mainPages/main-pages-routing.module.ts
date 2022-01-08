import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TiendaComponent } from './tienda/tienda.component';
import { ConfiguracionComponent } from './configuracion/configuracion.component';
import { NoticiasComponent } from './noticias/noticias.component';

const routes:Routes = [
  {
    path: 'BookStore',
    component: TiendaComponent,
  },
  {
    path: 'ProfileConfiguration',
    component: ConfiguracionComponent,
  },
  {
    path: 'News',
    component: NoticiasComponent,
  },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,    
    RouterModule.forRoot(routes)
  ],  
  exports: [
    RouterModule,
  ],
})
export class MainPagesRoutingModule { }
