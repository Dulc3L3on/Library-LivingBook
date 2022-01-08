import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, Routes } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [
  {
    path: 'login',
    component: LogInComponent,
  },
  {
    path: 'signup',
    component: SignUpComponent,
  }/*se necesita si no se utilizara MatDialog de angular material*/
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports:[
    RouterModule,
  ]
})
export class AutenticacionUsuarioRoutingModule { }
