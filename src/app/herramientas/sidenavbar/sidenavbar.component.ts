import { Component, OnInit } from '@angular/core';
import { SidenavbarServiceService } from './sidenavbar-service.service';

@Component({
  selector: 'app-sidenavbar',
  templateUrl: './sidenavbar.component.html',
  styleUrls: ['./sidenavbar.component.css']
})
export class SidenavbarComponent implements OnInit {
  

  constructor(private servicio_sideBar: SidenavbarServiceService) { }

  ngOnInit(): void {
  }

  showSideNavBar():void{
    this.servicio_sideBar.changeStateOfShowingMe();
  }

  /*implicitHiddenSideNav(evt){
    const {currentTarget: svg, pageX, pageY} = evt;

    if(pageY>480){
      this.showSideNavBar();
    }
  }*//*no se como manejar el evt*/
  

}
