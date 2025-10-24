import { Injectable } from '@angular/core';
import { Client, IMessage, Frame } from '@stomp/stompjs';
import { PedidoService } from './pedido.service';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  private stompClient?: Client;
  private readonly WS_URL = 'ws://192.168.1.157:8080/ws-pedidos';

  constructor(private pedidoService: PedidoService) {}

  connect(): void {
    this.stompClient = new Client({
      brokerURL: this.WS_URL,
      reconnectDelay: 5000,
      debug: (str) => console.log('[STOMP]', str),
    });

    this.stompClient.onConnect = (frame: Frame) => {
      console.log('Conectado ao WebSocket:', frame);

      // Assinatura do tópico de novos pedidos
      this.stompClient?.subscribe('/topic/pedidos', (message: IMessage) => {
        console.log('Novo pedido via WebSocket:', message.body);
        this.pedidoService.atualizarListas();
      });

      // Assinatura do tópico de atualização de status
      this.stompClient?.subscribe('/topic/pedidos-status', (message: IMessage) => {
        console.log('Pedido atualizado via WebSocket:', message.body);
        this.pedidoService.atualizarListas();
      });
    };

    this.stompClient.onStompError = (frame) => {
      console.error('Erro STOMP:', frame.headers['message'], frame.body);
    };

    this.stompClient.activate();
  }

  disconnect(): void {
    if (this.stompClient) {
      this.stompClient.deactivate();
      console.log('Desconectado do WebSocket');
    }
  }
}
