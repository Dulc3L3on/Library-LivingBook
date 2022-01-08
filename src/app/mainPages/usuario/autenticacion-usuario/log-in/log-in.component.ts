import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AutenticacionUsuarioService } from '../autenticacion-usuario.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(private autenticacionService:AutenticacionUsuarioService) { }

  ngOnInit(): void {
  }

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  hideMe():void{
    this.autenticacionService.hideAuthenticationWindow();
  }

  logIn():void{
    //se llama a la guarda login... [que en realidad creo que sería el autenticacionService, auqneu creo que el del tuto, usa algo de angular... para evitar repetir una lógica ya predefinida xD]
    //allá será donde se invoque el servlet para logearse, que en resumen
    //buscará si os datos concuerdan con algún usuario...
  }

}
