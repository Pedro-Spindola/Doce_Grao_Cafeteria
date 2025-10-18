import { Component } from '@angular/core';
import { MenuComponent } from "../../components/menu/menu.component";
import { ContainerPrimarioComponent } from "../../components/container-primario/container-primario.component";

@Component({
  selector: 'app-home',
  imports: [MenuComponent, ContainerPrimarioComponent],
  templateUrl: './home.page.html',
  styleUrl: './home.page.scss'
})
export class HomePage {

}
