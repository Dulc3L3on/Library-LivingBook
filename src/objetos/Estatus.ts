import { SuperObject } from "./SuperObject";

export class Estatus extends SuperObject{
    private tipoDeEstatus:string;
    private contenido:string;
    
    override tipo:string = "Estatus";

    constructor(tipo:string, contenido:string){
        super();

        this.tipoDeEstatus = tipo;
        this.contenido = contenido;
    }

    public get getTipo(){
        return this.tipoDeEstatus;
    }
    public get getContenido(){
        return this.contenido
    }
}