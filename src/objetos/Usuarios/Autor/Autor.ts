import { ConfiguracionCuenta } from "src/objetos/ConfiguracionCuenta";
import { Usuario } from "../Usuario";

export class Autor extends Usuario{
    fechaDecision!:string;
    descripcion!:string;
    cantidadMeGusta:number = 0;  
    
    override tipo:string = "Autor";

    constructor(nombre:string, apellido:string,username:string, genero:string,
        birthday:string, paisOrigen:string, password:string, correo:string, numeroTelefono:number,
        numeroTarjeta:number, descripcion:string){
        super(nombre, apellido, username, genero, birthday, paisOrigen, password,
            correo, numeroTelefono, numeroTarjeta, 1);

        this.fechaDecision = "";//puesto que se recibirá el objeto completo después de crearlo, no tiene sentido llenarlo :v xD y ya que cuando se busque un objeto se hará asignación (=), entonces el cnstrct no tiene porque tener paráms para todos los atrib del objeto...
        this.descripcion = descripcion;        
    }//el cnstruct es así puesto que cuando se crea aquí en Angular, solo a esos datos se tiene acceso xD
    //ya cuando se recibe de parte del backend no hay problema con que no aparezcan en el cnstruct, puesto que asigna directamente a las var que corresp
    //a los nombres de los "títulos" de contenido que aparecen en el JSON
        //bueno aunque no he probado que sucede si en el JSON aparece una var que no está definida aquí
        //imagino que no dará error y que omite ese dato y que simplemente no se puede acceder a ella desde aquí puesto que no hay con quién hacerlo        
}