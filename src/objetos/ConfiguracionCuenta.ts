import { SuperObject } from "./SuperObject";

export class ConfiguracionCuenta extends SuperObject{
     IDUsuario!:number;
     tema!:string;
     fotoPerfil!:string;//en Base64
     portada!:string;//en Base64, sin importar que decida que sea un gradiente o una imagen, si es gradiente pienso enviar el color así normal xD
     preferencias!:string[];//creo que por esto tendré que manejar las preferencias como un arreglo, porque no creo que este haga match con el ArrayList de java...

    override tipo:string = "Configuracion_Cuenta";

    constructor(IDUsuario:number, tema:string, fotoPerfil:string, portada:string, 
        preferencias:string[]){
        super();
        
        this.IDUsuario = IDUsuario;
        this.tema = tema;
        this.fotoPerfil = fotoPerfil;
        this.portada = portada;
        this.preferencias = preferencias;
    }

}