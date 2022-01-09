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

    public set setIdentificador(identificador:String){
        this.identificador = identificador;
    }
    public set setPassword(password:String){
        this.password = password;
    }

    public get getIdentificador(){
        return this.identificador;
    }
    public get getPassword(){
        return this.password;
    }
}