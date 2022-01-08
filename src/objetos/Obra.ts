import { Libro } from "./Libros/Libro";
import { Autor } from "./Usuarios/Autor/Autor";

export class Obra{
    private libro!:Libro;//serpa lbro o libro adquirido si es que la búsqueda es para tienda o miBiblioteca, respectivamente
    private autor!:Autor;

    constructor(libro:Libro, autor:Autor){
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