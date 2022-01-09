//vamos a ver si aquí resulta más fácil la herencia o tener todas las var en el objeto general, para así acceder a ellas SI el valor de una "bandera" indica que corresp al tipo especial...
//lo mismo app para AutorSeguido...

import { Libro } from "./Libro";

//Mira como lo hicieron M y T

export class LibroAdquirido extends Libro{
    tiempoLectura!:number;
    fechaAdquisicion!:String;
    meGusta!:number;

    override tipo:string = "Libro_Adquirido";

    constructor(ID:number, nombre:String, precio:number, IDAutor:number,
        fechaPublicacion:number, reseña:String, tipo:String, portada:String,
        archivoPDF:String, cantidadMeGusta:number,
        tiempoLectura:number, fechaAdquisicion:String, meGusta:number){
        
        super(ID, nombre, precio, IDAutor, fechaPublicacion, reseña, tipo,
            portada, archivoPDF, cantidadMeGusta);

        this.tiempoLectura = tiempoLectura;
        this.fechaAdquisicion = fechaAdquisicion;
        this.meGusta = meGusta;
    }

    public set setTiempoLectura(tiempoLectura:number){
        this.tiempoLectura = tiempoLectura;
    }
    public set setFechaAdquisicion(fechaAdquisicion:String){
        this.fechaAdquisicion = fechaAdquisicion;
    }
    public set setMeGusta(meGusta:number){
        this.meGusta = meGusta;
    }

    public get getTiempoLectura(){
        return this.tiempoLectura;
    }
    public get getFechaAdquisicion(){
        return this.fechaAdquisicion;
    }
    public get getMeGusta(){
        return this.meGusta;
    }
}