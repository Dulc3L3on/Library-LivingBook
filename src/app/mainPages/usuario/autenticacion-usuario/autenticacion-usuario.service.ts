import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Autenticacion } from 'src/objetos/Autenticacion';
import { Estatus } from 'src/objetos/Estatus';
import { Autor } from 'src/objetos/Usuarios/Autor/Autor';
import { Usuario } from 'src/objetos/Usuarios/Usuario';

@Injectable()
export class AutenticacionUsuarioService {
  private readonly API_URL_BASE = "http://localhost:8080/livingBook/";

  constructor(private router:Router, private httpClient:HttpClient) {} 

  hideAuthenticationWindow():void{
      this.router.navigate(['']);//recuerda que este método trabaja con rutas absolutas
  }

  loginUser(autenticacion:Autenticacion):Observable<Usuario|Estatus>{//creo que tb tendrá que se Obser de Estatus, y usar el método para obtener el usuario... y hacer proceso simi a lo que hace signin...
    return this.httpClient.post<Usuario|Estatus>(this.API_URL_BASE+"Login", autenticacion);   
  }

  registerUser(usuario:Usuario):Observable<Usuario|Estatus>{
    let formData = new FormData();
    formData.append(((usuario instanceof Autor)?"Autor":"Usuario"), JSON.stringify(usuario));
    
    return this.httpClient.post<Usuario|Estatus>(this.API_URL_BASE+"Signin_servlet", formData); 
  }

  /*obtainUser(credenciales:Autenticacion):Observable<Usuario>{
    return this.httpClient.get<Usuario>(this.API_URL_BASE+"Login");
    //mejor decicidí invocar en el backend al get en los post de login y signin, puesto que los datos de autenticación, 
    //tendría que enviarlos como parámetros y pensand en que fuera una aplicación oficial, eso no sería muy seguro, en 
    //cambio así la info no se revela tan fácilmente [imagino que al invocar a un post, los datos se cubren, sino que chiste :v,
    // de ser así los hubiera seteado como parámetros... :v]
  }*/

}
