import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BarraBusquedaModule } from './barra-busqueda/barra-busqueda.module';
import { RepositorioComponent } from './repositorio/repositorio.component';
import { BarraBusquedaComponent } from './barra-busqueda/barra-busqueda.component';
import { RepositorioModule } from './repositorio/repositorio.module';
import { HerramientasRoutingModule } from './herramientas-routing.module';
import { PreviewPdfModule } from './preview-pdf/preview-pdf.module';
import { DescriptionOfBookComponent } from './description-of-book/description-of-book.component';

@NgModule({
  declarations: [/*no declaré aquí el sidenavBar porque solo se empleará en la app-root */       
    DescriptionOfBookComponent
  ],
  imports: [
    CommonModule,
    BarraBusquedaModule, 
    RepositorioModule,
    PreviewPdfModule,
    HerramientasRoutingModule
  ],
  exports:[
    RepositorioComponent,
    BarraBusquedaComponent,
    PreviewPdfModule,
    HerramientasRoutingModule,
    DescriptionOfBookComponent
  ],  
})
export class HerramientasModule { }
