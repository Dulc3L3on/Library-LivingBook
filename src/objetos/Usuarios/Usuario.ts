import { ConfiguracionCuenta } from "../ConfiguracionCuenta";

export class Usuario{
    ID!:number;
    nombre!:String;
    apellido!:String;
    username!:String;
    genero!:String;
    birthday!:String;
    paisOrigen!:String;
    password!:String;
    correo!:String;
    numeroTelefono!:number;
    numeroTarjeta!:number;
    fechaUnion!:String;
    esAutor!:number;
    configuracionCuenta:ConfiguracionCuenta|null;

    constructor(nombre:String, apellido:String,username:String, genero:String,
        birthday:String, paisOrigen:String, password:String, correo:String, numeroTelefono:number,
        numeroTarjeta:number, esAutor:number){
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
            this.configuracionCuenta = null;
    }

    public set setID(ID:number){
        this.ID = ID;
    }
    public set setNombre(nombre:String){
        this.nombre = nombre;
    }
    public set setApellido(apellido:String){
        this.apellido = apellido;
    }
    public set setUsername(username:String){
        this.username = username;
    }
    public set setGenero(genero:String){
        this.genero = genero;
    }
    public set setBirthday(birthday:String){
        this.birthday = birthday;
    }
    public set setPassword(password:String){
        this.password = password;
    }
    public set setCorreo(correo:String){
        this.correo = correo;
    }
    public set setNumeroTelefono(numeroTelefono:number){
        this.numeroTelefono = numeroTelefono;
    }
    public set setNumeroTarjeta(numeroTarjeta:number){
        this.numeroTarjeta = numeroTarjeta;
    }
    public set setFechaUnion(fechaUnion:String){
        this.fechaUnion = fechaUnion;
    }
    public set setEsAutor(esAutor:number){
        this.esAutor = esAutor;
    }
    public set setConfiguracionCuenta(configuracionCuenta:any){
        this.configuracionCuenta = configuracionCuenta;
    }

    public get getID(){
        return this.ID;
    }
    public get getNombre(){
        return this.nombre;
    }
    public get getApellido(){
        return this.apellido;
    }
    public get getUsername(){
        return this.username;
    }
    public get getGenero(){
        return this.genero;
    }
    public get getBirthday(){
        return this.birthday;
    }
    public get getPassword(){
        return this.password;
    }
    public get getCorreo(){
        return this.correo;
    }
    public get getNumeroTelefono(){
        return this.numeroTelefono;
    }
    public get getNumeroTarjeta(){
        return this.numeroTarjeta;
    }
    public get getFechaUnion(){
        return this.fechaUnion;
    }
    public get getEsAutor(){
        return this.esAutor;
    }
    public get getConfiguracionCuenta(){
        return this.configuracionCuenta;
    }
}

//tengo que ver cómo le hicieron con la herencia y demás relaciones de POO
//dep por ejemplo xD

//y en el caso de T por qué no coloqué setters y getters...