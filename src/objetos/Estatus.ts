import { SuperObject } from "./SuperObject";

export class Estatus extends SuperObject{
    tipoDeEstatus:string;
    contenido:string;
    
    override tipo:string = "Estatus";

    constructor(tipo:string, contenido:string){
        super();

        this.tipoDeEstatus = tipo;
        this.contenido = contenido;
    }  
}