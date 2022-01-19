import { SuperObject } from "../SuperObject";

export class Libro extends SuperObject{
    ID!: number;    
    nombre!: String;    
    precio!: number;    
    IDAutor!: number;    
    fechaPublicacion!: number;    
    reseña!: String;   
    tipoDeLibro!: String;    
    portada!: String;    
    archivoPDF!: String;   
    cantidadMeGusta!: number;  

    override tipo:string = "Libro";

    constructor(ID:number, nombre:String, precio:number, IDAutor:number,
        fechaPublicacion:number, reseña:String, tipo:String, portada:String,
        archivoPDF:String, cantidadMeGusta:number){
        super();
            this.ID = ID;
            this.nombre = nombre;
            this.precio = precio;
            this.IDAutor = IDAutor;
            this.fechaPublicacion = fechaPublicacion;
            this.reseña = reseña;
            this.tipoDeLibro = tipo;
            this.portada = portada;
            this.archivoPDF = archivoPDF;
            this.cantidadMeGusta = cantidadMeGusta;
    }
}