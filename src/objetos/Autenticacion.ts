import { SuperObject } from "./SuperObject";

export class Autenticacion extends SuperObject{
    identificador:String;
    password:String;

    override tipo:string = "Autenticacion";

    constructor(identificador:String, password:String){
        super();

        this.identificador = identificador;
        this.password = password;
    }   
}