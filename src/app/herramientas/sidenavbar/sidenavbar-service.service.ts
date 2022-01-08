import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'/*lo dejo así puesto que lo va a utilizar directamente solo la página principal y en todo caso, necesito que sea una misma instancia la que todos posean de este servicio en cuestión... */
})
export class SidenavbarServiceService { 
  private showMe=false;
  
  constructor(private router:Router, private route:ActivatedRoute) { }

  /*showSideNavBar(showMe:boolean):boolean{
    if(showMe){
      this.router.navigate(['sidenav-bar']);

    }else{
      this.router.navigate(['']);
      console.log('the parent route: '+this.route.parent?.url);//para ver si sí alamacena la ruta que aparece antes de slidenav, aunque ahora que lo pienso, cada vez que presione el botón para ver este menu, eliminará toda la ruta actual para mostrarlo, y por eso, sin importar dónde esté cuando de click en eso, regresará a la página principal o raíz...
    }
    
    return !showMe;
  }*//*ya no será útil, y creo que este servicio tampoco... */

  changeStateOfShowingMe(){
    this.showMe = !this.showMe;
  }

  getShowMe():boolean{
    return this.showMe;
  }


  /*el plan es para usar este sin problemas, crear un ngtemplate, que solo se muestre SI una var es true, de tal forma que el valor de esta
  var sea cambiada por el método del evt click y así se quite y ponga el elemento en el DOM, sin problemas; por ello la barra de búsquedas deberá
  cubrir la parte de encabezado que abarca y dejar todo lo demás como "modal", es decir, así como se hizo con las ventanas del login, de tal forma que no 
  se altere nada y se quede todo tal y como lo dejó antes de presionar el botón para mostrar el div... :D 
  
  y creo que por eso ya no se requerirá de add el path en el routing del app-component... creo xD, SI ES NECESARIO aqunque llames el compoennte directamente por medio del selector...*/

}
