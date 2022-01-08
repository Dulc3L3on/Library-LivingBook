import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Subscription } from 'rxjs';
import { Estatus } from 'src/objetos/Estatus';
import { Autor } from 'src/objetos/Usuarios/Autor/Autor';
import { Usuario } from 'src/objetos/Usuarios/Usuario';
import { AutenticacionUsuarioService } from '../autenticacion-usuario.service';
import Swal from 'sweetalert2';
import { repositorioLocalService } from 'src/app/repositorioLocal/repositorioLocal.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  mostrarDescripcion:boolean = false;
  private suscripcion!:Subscription;

  signUpForm = new FormGroup({
    esAutor: new FormControl(false),
    name: new FormControl(''),
    lastname: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    gender: new FormControl('Select your gender'),
    birthday: new FormControl(''),
    country: new FormControl('Select your native country'),//en el caso de los select, el valor que se envíe en el formControl debe corresp a una de las opciones que tenga decladas, sea que estén habilitadas o no...
    phone: new FormControl(''),
    email: new FormControl(''),
    tarjeta: new FormControl(null),    
  });

 constructor(private router:Router,
             private autenticacionService:AutenticacionUsuarioService,
             private repositorioLocalService:repositorioLocalService){}

  ngOnInit(): void {}

  ngOnDestroy():void {
    this.suscripcion.unsubscribe();
  }

  hideMe():void{
    this.autenticacionService.hideAuthenticationWindow();
  }

  manejarCampoDescripcionPropia(){
    this.mostrarDescripcion = !this.mostrarDescripcion;

    if(this.mostrarDescripcion){
      this.agregarFormControl();
    }else{
      this.eliminarDescripcion();
    }   
  }

  agregarFormControl(){
    //document.getElementById('ownDescription')!.style.display ='';
    document.getElementById('modal')!.style.height="770px";
    document.getElementById('contentSignUp')!.style.height="715px";
    document.getElementById('button')!.style.marginTop="65px";

    this.signUpForm.addControl("descripcion", new FormControl());    
  }

  eliminarDescripcion(){
    //document.getElementById('ownDescription')!.style.display ='none';
    document.getElementById('modal')!.style.height="630px";
    document.getElementById('contentSignUp')!.style.height="590px";
    document.getElementById('button')!.style.marginTop="23px";

    this.signUpForm.removeControl("descripcion");
  }

  signIn(){    
    console.log("es Autor?"+this.signUpForm.value.esAutor);//quiero ver que devulve cuando un campo está vacío, "" o null; esto tb servirá para así colocar de manera correcta las condiciones ternarias

    this.suscripcion = this.autenticacionService.registerUser(((this.signUpForm.value.esAutor)
    ?new Autor(this.signUpForm.value.name, this.signUpForm.value.lastname, this.signUpForm.value.username,
      this.signUpForm.value.gender, this.signUpForm.value.birthday, this.signUpForm.value.country,
      this.signUpForm.value.password, this.signUpForm.value.email, this.signUpForm.value.phone, 
      ((this.signUpForm.value.tarjeta!=null)?this.signUpForm.value.tarjeta:-1), this.signUpForm.value.descripcion)
    :new Usuario(this.signUpForm.value.name, this.signUpForm.value.lastname, this.signUpForm.value.username,
      this.signUpForm.value.gender, this.signUpForm.value.birthday, this.signUpForm.value.country,
      this.signUpForm.value.password, this.signUpForm.value.email, this.signUpForm.value.phone, 
      ((this.signUpForm.value.tarjeta!=null)?this.signUpForm.value.tarjeta:-1), 0))).subscribe(
        (resultado:Usuario|Estatus) => {//o mejor uso Object?
          if(resultado instanceof Usuario || resultado instanceof Autor){//o solo bastará con Usuario? fmmm xD
             let usuario = ((resultado instanceof Autor)? resultado as Autor: resultado as Usuario);//Se recibe el usuario en la forma corresp
             this.repositorioLocalService.setUsuario(((usuario.esAutor == 0)?"Lector":"Autor"), usuario);//se guarda en el almacenamiento
             this.router.navigate(["Bookstore"]);
            //se redirige con la sesión iniciada..

          }else{
            let estatus = resultado;//:0, detecta automáticamente que es Estatus, por el hecho de estar en un else :0

            Swal.fire({
              icon: 'error',
              title: resultado.getTipo,
              text: resultado.getContenido,
              //hay que ver cómo hizo o en la página o un tuto xD, lo del sweet :v 
            })
          }
        },
        (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Ha surgido un error al tranportar los datos',
            footer:error
          })//error 500 [al generar el stream (recibir o enviar info, creo que eso había dicho :v)]
        }
      );


     
      


    //si esAutor = true/!=null, entonces creas un autor, sino un usuario
    //igualas la var de suscripcion para asignar el valor luego de suscribirte
    //tienes que ver qué tipo de objeto recibiste
      //si es estatus, entonces mandas a llamar al componente que muestra los msjes, muestras el msje
      //si es un tipo de usuario, entonces guardas el valor en el respsitorio [que será un servicio global [proveido en appModule]], rediriges a tienda con el perfil corresp [el campo de config ya tiene el base64 de la img por defecto, entonces no hay que colocar un inf != null o algo parecido, porque por medio de esa base64 te ahorraste esa revisión]
      //creas el onDestroy para cancelar la suscripción
    //DEBES revisar cómo le hizo Marcos para setear en el objeto correcto, lo digo porque recuerdo que append un tipo de objeto diferente dependiendo de si había catchaedo algo o no
    //sino deplano que con el instanceof será...
    //pero antes debes ver cómo le hicieron par convertir el JSON a un objeto en Angular...

    //hay que ver el error del text area de descripcion... creo que es porque envío mal los valores de display...
    
    /*el eqq del proceso a realizar en login xD */


    //OWO v
    //tendría que volver a esta dirección, si la cta ya está creada y mostrar un msje debajo del botón indicando que esos datos ya
    // están registrados para el caso de username y 
      //eso estaría bueno mostrarlo antes de permitir que envíe el form...
    //que la cta ya existe al tener una coincidencia con: name, lastname, email 
    //[puesto que creo que google evita que el nombre de los correos se repita...
  }
}
