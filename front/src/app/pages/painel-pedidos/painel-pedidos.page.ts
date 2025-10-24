import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PedidoSimples } from '../../models/PedidoSimples';
import { PedidoService } from '../../services/pedido.service';
import { CommonModule } from '@angular/common';
import { WebSocketService } from '../../services/web-socket.service';

@Component({
  selector: 'app-painel-pedidos',
  imports: [CommonModule],
  templateUrl: './painel-pedidos.page.html',
  styleUrl: './painel-pedidos.page.scss'
})
export class PainelPedidosPage implements OnInit {
  pedidosPagos$!: Observable<PedidoSimples[]>;
  pedidosRetirada$!: Observable<PedidoSimples[]>;

  constructor(private pedidoService: PedidoService, private webSocketService: WebSocketService) {}

  ngOnInit(): void {
    this.pedidosPagos$ = this.pedidoService.pedidosPagosSubject$;
    this.pedidosRetirada$ = this.pedidoService.pedidosRetirada$;
    this.pedidoService.atualizarListas();
    this.webSocketService.connect();
  }
}
