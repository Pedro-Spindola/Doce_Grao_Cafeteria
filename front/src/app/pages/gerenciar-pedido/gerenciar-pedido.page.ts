import { Component, OnInit } from '@angular/core';
import { PedidoSimples } from '../../models/PedidoSimples';
import { Observable } from 'rxjs';
import { PedidoService } from '../../services/pedido.service';
import { CommonModule } from '@angular/common';
import { WebSocketService } from '../../services/web-socket.service';

@Component({
  selector: 'app-gerenciar-pedido',
  imports: [CommonModule],
  templateUrl: './gerenciar-pedido.page.html',
  styleUrl: './gerenciar-pedido.page.scss'
})
export class GerenciarPedidoComponent implements OnInit {

  pedidosPagos$!: Observable<PedidoSimples[]>;
  pedidosRetirada$!: Observable<PedidoSimples[]>;

  constructor(private pedidoService: PedidoService, private webSocketService: WebSocketService) {}

  ngOnInit(): void {
    // conecta o componente às listas do service
    this.pedidosPagos$ = this.pedidoService.pedidosPagosSubject$;
    this.pedidosRetirada$ = this.pedidoService.pedidosRetirada$;

    // atualiza as listas ao carregar o componente
    this.pedidoService.atualizarListas();
    this.webSocketService.connect();
  }

  atualizarStatus(pedido: PedidoSimples): void { 
    console.log('Botão clicado para pedido:', pedido);
    this.pedidoService.atualizarStatus(pedido.id).subscribe({
      next: (res) => {
        console.log('Status atualizado:', res);
        this.pedidoService.atualizarListas();
      },
      error: (err) => {
        console.error('Erro ao atualizar status:', err);
      }
    });
  }
}
