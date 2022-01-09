import { Injectable } from "@angular/core";
import { Autor } from "src/objetos/Usuarios/Autor/Autor";
import { Usuario } from "src/objetos/Usuarios/Usuario";

@Injectable({
    providedIn: 'root'
})
export class GeneralToolService{   
    
    /*public isAnUser(theObject:any):theObject is Usuario{
        return (theObject as Usuario).getApellido !== undefined;         
    }

    public isAnAutor(theObject:any):theObject is Autor{
        return (theObject as Autor).getDescripcion !== undefined;         
    }*///no funciona cuando el parámetro recibido es de tipo object, con any yo diría que si xD

}