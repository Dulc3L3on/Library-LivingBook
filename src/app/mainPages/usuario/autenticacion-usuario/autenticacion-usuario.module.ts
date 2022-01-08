import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogInComponent } from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AutenticacionUsuarioRoutingModule } from './autenticacion-usuario-routing.module';
import { AutenticacionUsuarioService } from './autenticacion-usuario.service';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ 
    LogInComponent,
    SignUpComponent,
  ],
  imports: [
    CommonModule,
    AutenticacionUsuarioRoutingModule,      
    ReactiveFormsModule
  ],
  exports:[
    LogInComponent,
    SignUpComponent,    
  ],
  providers:[
    AutenticacionUsuarioService,
  ],
})

export class AutenticacionUsuarioModule {}
