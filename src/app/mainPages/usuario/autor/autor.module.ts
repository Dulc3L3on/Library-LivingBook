import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BannerPresentacionComponent } from './banner-presentacion/banner-presentacion.component';
import { EstadisticasComponent } from './estadisticas/estadisticas.component';
import { HerramientasModule } from 'src/app/herramientas/herramientas.module';
import { CreaciononesModule } from './creaciones/creacionones.module';

/*mira si es necesario el ROUTING MODULE para autor, es decir si además de que quieras que aparezca el nombre en la URL, te beneficia en algo, como por ejemplo en el envío de paráms... de los cuales aún no sabes si los requerirás, como dije, es solo un ejemplo... */

@NgModule({
  declarations: [
    BannerPresentacionComponent,     
    EstadisticasComponent,
  ],
  imports: [
    CommonModule,
    HerramientasModule,
    CreaciononesModule,
  ],
  exports:[
    BannerPresentacionComponent,    
    EstadisticasComponent,
    CreaciononesModule,
  ]
})
export class AutorModule { }
