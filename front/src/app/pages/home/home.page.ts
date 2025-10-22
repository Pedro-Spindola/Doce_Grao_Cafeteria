import { Component } from '@angular/core';
import { MenuComponent } from "../../components/menu/menu.component";
import { CommonModule } from '@angular/common';
import { RouterModule } from "@angular/router";

@Component({
  selector: 'app-home',
  imports: [CommonModule, MenuComponent, RouterModule],
  templateUrl: './home.page.html',
  styleUrl: './home.page.scss'
})
export class HomePage {

}
