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

    public set setID(value: number) {
        this.ID = value;
    }
    public get getID(): number {
        return this.ID;
    }

    public get getNombre(): String {
        return this.nombre;
    }
    public set setNombre(value: String) {
        this.nombre = value;
    }

    public get getPrecio(): number {
        return this.precio;
    }
    public set setPrecio(value: number) {
        this.precio = value;
    }

    public get getIDAutor(): number {
        return this.IDAutor;
    }
    public set setIDAutor(value: number) {
        this.IDAutor = value;
    }

    public get getFechaPublicacion(): number {
        return this.fechaPublicacion;
    }
    public set setFechaPublicacion(value: number) {
        this.fechaPublicacion = value;
    }

    public get getReseña(): String {
        return this.reseña;
    }
    public set setReseña(value: String) {
        this.reseña = value;
    }

    public get getTipo(): String {
        return this.tipoDeLibro;
    }
    public set setTipo(value: String) {
        this.tipoDeLibro = value;
    }

    public get getPortada(): String {
        return this.portada;
    }
    public set setPortada(value: String) {
        this.portada = value;
    }

    public get getArchivoPDF(): String {
        return this.archivoPDF;
    }
    public set setArchivoPDF(value: String) {
        this.archivoPDF = value;
    }

    public get getCantidadMeGusta(): number {
        return this.cantidadMeGusta;
    }
    public set setCantidadMeGusta(value: number) {
        this.cantidadMeGusta = value;
    }
}