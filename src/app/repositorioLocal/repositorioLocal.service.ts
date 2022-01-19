import { Injectable } from "@angular/core";
import { Autor } from "src/objetos/Usuarios/Autor/Autor";
import { Usuario } from "src/objetos/Usuarios/Usuario";

@Injectable({
    providedIn: 'root',
  })
  
export class repositorioLocalService{//estaba pensando instanciar el servicio en lugar de inyectarlo, pero no se si al hacer eso creará más de una isntancia de localStorage; yo pienso que no porque es una propiedad global del proyecto, pero mejor usar inyección, porque si no lo hago cada vez que creara una instancia, tendría que enviarle el usuario, y eso no conviene en lo absoluto ;-;, no se en que estaba pensando xD
    tipoUsuario:string|null = null;

    constructor(){}
            
    public setUsuario(key:string, usuario:Usuario){//puesto que este se debe crear cuando alguien inicie sesión, ya sea la primera vez o no xD
        localStorage.clear;
        this.tipoUsuario = key;

        localStorage.setItem(key, JSON.stringify(usuario));
    }
    /*será empleado después de que el usuario haya
      editado algo, ya sea su tipo o cualquier otro
      feature xD */
      public resetUsuario(tipo:string, usuario:Usuario){
        this.tipoUsuario = tipo;

        localStorage.removeItem(tipo);
        localStorage.setItem(tipo, JSON.stringify(usuario));
    }
    
    /*este será útil para setear listas, p.ej las de miBiblio
      utilizar esto dependerá de qué tan conveniente sea, puesto
      que este método lo add pensando en que como otras páginas
      requieren de los datos de esa lista (asíc como de las otras)
      sería mejor guardar la lista en el frontend, para no tener 
      que hacer muchas peticiones, solamente cuando OnInit y cuando
      regrese a la página (p.ej cuando la refresque, en general 
      cuando vuelva a leerse la página...)*/
    public setObject(key:string, objeto:Object){
        localStorage.setItem(key, JSON.stringify(objeto));
    }

    public setData(key:string, data:string){        
        localStorage.setItem(key, data);
    }

    public resetObject(key:string, objeto:Object){
        localStorage.removeItem(key);
        localStorage.setItem(key, JSON.stringify(objeto));
    }

    public resetData(key:string, data:string){
        localStorage.removeItem(key);
        localStorage.setItem(key, data);
    }

    public get getTipoUsuario(){
        return this.tipoUsuario;
    }

    public get getUsuario():Usuario|Autor|null{
        return ((this.tipoUsuario != null)
        ?((this.getObjeto("Usuario")!= null)
          ?(this.getObjeto("Usuario") as Usuario)
          :(this.getObjeto("Autor") as Autor))
        :null);
    }//si devuleve Object, entonces colocarás esto en cada plantilla que lo requiera, o si quieres preservar esto aquí, add los as tb allá [creo que para que se pueda "castear" bien en la otra clase .ts debe dejarse los "as" aquí... creo xD]

    public getObjeto(key:string):Object{//si te da problemas por parseo entonces, haz un método que devuelva Objects, y para devolver usuario, lo mismo que hizo Marcos o uno que invoque al que devulve OBject, parsee y tenga de tipo de retorno Usuario..., independendientemenete de cómo lo hagas, por medio del tipo de usuario, haces el parseo corresp...
        return JSON.parse(`${localStorage.getItem(key)}`);//puesto que aunque fuera null, lo convertiría a string...
    }

    public getData(key:string):String|null{
        return localStorage.getItem(key);
    }

    public clearStorage(){
        localStorage.clear;//mejor guardaré al usuario aquí y no en la sesión, así puedo guardarlo como un observable al que haga ref un BehaviorSubject y así cuando usen los métodos para setaeer, resetear o eli, aquí pueda estar informada, lo que no sé es si dará problemas por el hecho de la herencia... yo esperaría que no xD
    }    
}