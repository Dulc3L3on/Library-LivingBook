import { Libro } from "./Libros/Libro";
import { SuperObject } from "./SuperObject";
import { Autor } from "./Usuarios/Autor/Autor";

export class Obra extends SuperObject{
    private libro!:Libro;//serpa lbro o libro adquirido si es que la búsqueda es para tienda o miBiblioteca, respectivamente
    private autor!:Autor;

    override tipo:string = "Obra";

    constructor(libro:Libro, autor:Autor){
        super();

        this.libro = libro;
        this.autor = autor;
    }

    public get getLibro(){
        return this.libro;
    }
    public get getAutor(){
        return this.autor;
    }
}