import { Component } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA, MatDialogConfig} from '@angular/material/dialog';
import { SidenavbarServiceService } from './herramientas/sidenavbar/sidenavbar-service.service';
import { AutenticacionUsuarioService } from './mainPages/usuario/autenticacion-usuario/autenticacion-usuario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'livingBook';
  marcarIcono:string[]=['',''];//0-> bell, 1-> door  
    
  constructor(private dialogo: MatDialog, private servicio_autenticacion: AutenticacionUsuarioService, private servicio_navBar: SidenavbarServiceService){}

  /*setComponentDialog(tipo:string):void{
    this.servicio_autenticacion.setComponentDialog(tipo, this.dialogo);
  }*//*no se utilizará angular material porque le cambia de estilo :p*/ 

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

}
