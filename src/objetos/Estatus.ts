export class Estatus{
    private tipo:string;
    private contenido:string;

    constructor(tipo:string, contenido:string){
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public get getTipo(){
        return this.tipo;
    }
    public get getContenido(){
        return this.contenido
    }
}