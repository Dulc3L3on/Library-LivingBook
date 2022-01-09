import { ConfiguracionCuenta } from "src/objetos/ConfiguracionCuenta";
import { Autor } from "./Autor";

export class AutorSeguido extends Autor{
    meGusta:number = 0;
    seguidoDesde!:String;

    override tipo:string = "Autor_Seguido";

    constructor(nombre:string, apellido:string,username:string, genero:string,
        birthday:string, paisOrigen:string, password:string, correo:string, numeroTelefono:number,
        numeroTarjeta:number, descripcion:string){//y hasta estoy pensando que como este obj solo se crerá al recibirse una lista desde el backend, es decir no se creará "explícitamente" aquí, no tendría porqué tener un cnstrct, pero como hereda entonces lo dejé... por eso no creo que se requiera el parám de #MeGusta porque se obtendrá directamten de la asignación (=) del obj obtenido por medio del backend...
        
        super(nombre, apellido, username, genero, birthday, paisOrigen, password,
            correo, numeroTelefono, numeroTarjeta, descripcion);
        
        this.seguidoDesde = "";
    }    

    public set setMeGusta(meGusta:number){
        this.meGusta = meGusta;
    }
    public set setSeguidoDesde(seguidoDesde:String){//aún no sé si la fecha cb cuando lo deje de seguir o no, yo diría que sí...
        this.seguidoDesde = seguidoDesde;
    }//de los que tiene setter había dicho que poseían proque los campos pueden cb de valor. No los eliminaré mientras aún no tenga bien pensado cómo enviar la info al backend y si debería o no enviar el obj completo hacia acá... es decir se mantendrán hasta que esté codificando el intercambio de info corresp xD :D

    public get getMeGusta(){
        return this.meGusta;
    }
    public get getSeguidoDesde(){
        return this.seguidoDesde;
    }
}