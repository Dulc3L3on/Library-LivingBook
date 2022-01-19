import { Libro } from "./Libros/Libro";
import { SuperObject } from "./SuperObject";
import { Autor } from "./Usuarios/Autor/Autor";

export class Obra extends SuperObject{
    libro!:Libro;//serpa lbro o libro adquirido si es que la búsqueda es para tienda o miBiblioteca, respectivamente
    autor!:Autor;

    override tipo:string = "Obra";

    constructor(libro:Libro, autor:Autor){
        super();

        this.libro = libro;
        this.autor = autor;
    }
}