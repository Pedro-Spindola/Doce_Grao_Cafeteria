import { Routes } from '@angular/router';
import { HomePage } from './pages/home/home.page';
import { PedidoPage } from './pages/pedido/pedido.page';

export const routes: Routes = [
    { path: '', component: HomePage},
    { path: 'pedido', component: PedidoPage}
];
