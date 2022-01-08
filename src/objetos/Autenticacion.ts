export class Autenticacion{
    identificador:String;
    password:String;

    constructor(identificador:String, password:String){
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