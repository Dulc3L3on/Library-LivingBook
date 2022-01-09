import { ConfiguracionCuenta } from "src/objetos/ConfiguracionCuenta";
import { Usuario } from "../Usuario";

export class Autor extends Usuario{
    fechaDecision!:string;
    descripcion!:string;
    cantidadMeGusta:number = 0;  
    
    override tipo:string = "Autor";

    constructor(nombre:string, apellido:string,username:string, genero:string,
        birthday:string, paisOrigen:string, password:string, correo:string, numeroTelefono:number,
        numeroTarjeta:number, descripcion:string){
        super(nombre, apellido, username, genero, birthday, paisOrigen, password,
            correo, numeroTelefono, numeroTarjeta, 1);

        this.fechaDecision = "";//puesto que se recibirá el objeto completo después de crearlo, no tiene sentido llenarlo :v xD y ya que cuando se busque un objeto se hará asignación (=), entonces el cnstrct no tiene porque tener paráms para todos los atrib del objeto...
        this.descripcion = descripcion;        
    }

    public set setFechaDecision(fechaDecision:string){
        this.fechaDecision = fechaDecision;
    }
    public set setDescripcion(descripcion:string){
        this.descripcion = descripcion;
    }
    public set setCantidadMeGusta(cantidadMeGusta:number){
        this.cantidadMeGusta = cantidadMeGusta;
    }
    public get getFechaDecision(){
        return this.fechaDecision;
    }
    public get getDescripcion(){
        return this.descripcion;
    }
    public get getCantidadMeGusta(){
        return this.cantidadMeGusta;
    }
}