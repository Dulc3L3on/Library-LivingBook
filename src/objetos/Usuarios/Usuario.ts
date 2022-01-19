import { ConfiguracionCuenta } from "../ConfiguracionCuenta";
import { SuperObject } from "../SuperObject";

export class Usuario extends SuperObject{
    ID!:number;
    nombre!:String;
    apellido!:string;
    username!:string;
    genero!:string;
    birthday!:string;
    paisOrigen!:string;
    password!:string;
    correo!:string;
    numeroTelefono!:number;
    numeroTarjeta!:number;
    fechaUnion!:string;
    esAutor!:number;
    configuracionCuenta!:ConfiguracionCuenta;

    override tipo:string = "Usuario";

    constructor(nombre:string, apellido:string,username:string, genero:string,
        birthday:string, paisOrigen:string, password:string, correo:string, numeroTelefono:number,
        numeroTarjeta:number, esAutor:number){//creo que sería bueno que tb coocara aquí COnfiguracionCta, porque al final de cta xD, este dato siempre lo tendrá el usuario que reciba desde el backend...
        super();
            this.ID = -1;
            this.nombre = nombre;
            this.apellido = apellido;
            this.username = username;
            this.genero = genero;
            this.birthday = birthday;
            this.paisOrigen = paisOrigen;
            this.password = password;
            this.correo = correo;
            this.numeroTelefono = numeroTelefono;
            this.numeroTarjeta = numeroTarjeta;
            this.fechaUnion = "";
            this.esAutor = esAutor;            
    }
  
}

//tengo que ver cómo le hicieron con la herencia y demás relaciones de POO
//dep por ejemplo xD

//y en el caso de T por qué no coloqué setters y getters...