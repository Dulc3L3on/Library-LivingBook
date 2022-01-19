import { Component, OnDestroy} from '@angular/core';
import { ConfiguracionCuenta } from 'src/objetos/ConfiguracionCuenta';
import { Autor } from 'src/objetos/Usuarios/Autor/Autor';
import { Usuario } from 'src/objetos/Usuarios/Usuario';
import { SidenavbarServiceService } from './herramientas/sidenavbar/sidenavbar-service.service';
import { AutenticacionUsuarioService } from './mainPages/usuario/autenticacion-usuario/autenticacion-usuario.service';
import { repositorioLocalService } from './repositorioLocal/repositorioLocal.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'livingBook';
  marcarIcono:string[]=['',''];//0-> bell, 1-> door  
  usuario:Usuario|null = null;
    
  constructor(private servicio_autenticacion: AutenticacionUsuarioService,
              private servicio_navBar: SidenavbarServiceService,
              private repositorioLocal:repositorioLocalService){}
  
  /*changeStateOfIcon(esMarcar:string, indice:number){
    this.marcarIcono[indice]=esMarcar;

    console.log(this.marcarIcono[0]);
  }*/  
  
  logOut(){//a menos que coloques un div que pregunte si de verdad quiere cerrar sesión, no es necesario que tenga una var para saber si debe cambiar o no de aspecto, porque el deslogeo es instantáneo que no permitiría ver el cambio al color negro...
    //para invocar al div puede hacerse que el botón tenga un a con un ROUTERLINK
    //hacer que se invoque este método por medio de CLICK y que este contenga un NAVIGATE
    //o hacer que se invoque a este método por medio de CLICK y que este cambie el estado de una var que haga que el template que envuelva el selector del logoutDiv

    //al tener un div, ese sería el que poseería en su clase.ts o un service, depende de como se manejen las llamadas a código externo, para deslogear al user
    //no olvides que en cualquiera de los casos tendrías que cambiar el aspecto de la puertecita xD, deplano que eso si se hará un un click independientemente de cómo se invoque al DIV xD, ya sea para que solo se ponga negro al ser el click, o que se ponga negro MIENTRAS esté el div, y si se cancela, o cierre este, que se ponga blanco... por el hecho de tener que recuperar una respuesta, sería bueno que probaras con el sweet xD
  }

  showSideNavBar():void{
    //aquí la incocación al método del servicio xD
    //this.showComponent[2] = !this.showComponent[2];

    this.servicio_navBar.changeStateOfShowingMe();
  }

  getStateOfShowingNavBar():boolean{
    return this.servicio_navBar.getShowMe();
  }

  get getUsuario():Usuario|null{
    console.log("objeto almacenado v")
    console.log((this.repositorioLocal.getObjeto("Usuario")));//hay que ver si da null o "null"
    this.usuario = this.repositorioLocal.getUsuario as Usuario;//si no se vuelve a exe cada vez que se muestre esta página, entonces lo add a un método que se exe cada vez que se lea el ng-template del .html...
    
    return this.usuario;
  }

  getProfile():string{    
    console.log("get profile");    
    console.log(this.usuario);
    console.log("foto perfil "+(this.usuario!.configuracionCuenta as ConfiguracionCuenta).fotoPerfil!);    
    return ((this.usuario!).configuracionCuenta as ConfiguracionCuenta).fotoPerfil!;
  }

//algo está fallando con el getProfile [imagino que es la interpolación], 
//y es mejor que getUsuario se reemplazara por un observble, pues se invoca muuuchas veces o se ponga en un mejor lugar, iba a decir que se regresara al cnstruc, pero eso evitaría la actualización de la var usuario, o eso pienso xD


  ngOnDestroy():void{
    this.repositorioLocal.clearStorage();
  }

}


//hay que ver si al almacenar el objeto en la sesión, permanece ahí si no le digo explícitamente que sea "delete" o se borra al cerrarse la sesión [o en este caso el servidor xD]