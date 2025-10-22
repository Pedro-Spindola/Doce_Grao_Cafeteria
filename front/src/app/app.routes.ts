import { Routes } from '@angular/router';
import { HomePage } from './pages/home/home.page';
import { PedidoPage } from './pages/pedido/pedido.page';
import { ContainerCafesComponent } from './components/container-cafes/container-cafes.component';
import { ContainerApresentacaoComponent } from './components/container-apresentacao/container-apresentacao.component';

export const routes: Routes = [
  {
    path: 'home',
    component: HomePage,
    children: [
      { path: 'cafes', component: ContainerCafesComponent },
      { path: '', component: ContainerApresentacaoComponent },
    ]
  },
  { path: 'pedido', component: PedidoPage },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home' }
];
