import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HerramientasModule } from './herramientas/herramientas.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { SidenavbarComponent } from './herramientas/sidenavbar/sidenavbar.component';
import { MainPagesModule } from './mainPages/main-pages.module';
import { AutenticacionUsuarioModule } from './mainPages/usuario/autenticacion-usuario/autenticacion-usuario.module';
import { ErrorAdviseComponent } from './error/error-advise/error-advise.component';

@NgModule({
  declarations: [
    AppComponent,           
    SidenavbarComponent, 
    ErrorAdviseComponent,    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HerramientasModule,/*peinso que no debería estar aquí porque se encuentra el modulo de las MainPages, revisa el error en google pero más creo qe es porque importaste un módulo en más de 1 lugar...*/  
    BrowserAnimationsModule, /*importé el módulo puesto que este es un FeatureModule y por lo tanto debo utilizar los componentes que contiene, en otras partes... */
    AutenticacionUsuarioModule,    
    MatDialogModule,
    MainPagesModule,
    HttpClientModule
  ],
  exports:[],
  providers: [],
  bootstrap: [AppComponent],
  
})
export class AppModule { }
