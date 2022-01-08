export class ConfiguracionCuenta{
    private IDUsuario!:number;
    private tema!:String;
    private fotoPerfil!:String;//en Base64
    private portada!:String;//en Base64, sin importar que decida que sea un gradiente o una imagen, si es gradiente pienso enviar el color así normal xD
    private preferencias!:Array<String>;//creo que por esto tendré que manejar las preferencias como un arreglo, porque no creo que este haga match con el ArrayList de java...

    constructor(IDUsuario:number, tema:String, fotoPerfil:String, portada:String, 
        preferencias:Array<String>){

        this.IDUsuario = IDUsuario;
        this.tema = tema;
        this.fotoPerfil = fotoPerfil;
        this.portada = this.portada;
        this.preferencias = preferencias;
    }

    public set setIDUsuario(IDUsuario:number){
        this.IDUsuario = IDUsuario;
    }
    public set setTema(tema:String){
        this.tema = tema;
    }
    public set setFotoPerfil(fotoPerfil:String){
        this.fotoPerfil = fotoPerfil;
    }
    public set setPortada(portada:String){
        this.portada = portada;
    }
    public set setPreferencias(preferencias:Array<String>){
        this.preferencias = preferencias;
    }

    public get getIDUsuario(){
        return this.IDUsuario;
    }
    public get GetTema(){
        return this.tema;
    }
    public get getFotoPerfil(){
        return this.fotoPerfil;
    }
    public get getPortada(){
        return this.portada;
    }
    public get getPreferencias(){
        return this.preferencias;
    }
}