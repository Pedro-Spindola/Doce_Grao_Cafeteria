import { Component, OnInit } from '@angular/core';
import { PedidoResponse } from '../../models/PedidoResponse';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-finalizado',
  imports: [CommonModule, FormsModule],
  templateUrl: './finalizado.page.html',
  styleUrl: './finalizado.page.scss'
})
export class FinalizadoPage implements OnInit{
  pedido!: PedidoResponse;

  constructor(private router: Router){}

  ngOnInit(): void {
    this.recuperarDadosDoPedido();
  }

  recuperarDadosDoPedido(): void {
    // 💥 RECUPERAÇÃO: Acessa o objeto history.state do navegador
    const state = history.state;
    
    // Verifica se a chave customizada 'pedidoFinalizado' existe no estado
    if (state && state.pedidoFinalizado) {
      this.pedido = state.pedidoFinalizado as PedidoResponse;
      
      // Opcional: Log para verificar
      console.log('Pedido recuperado na página finalizada:', this.pedido);
      
    } else {
      // Caso o usuário acesse a página /finalizado diretamente ou o state tenha sido perdido
      console.warn('Dados do pedido não encontrados no histórico de navegação.');
      // Opcional: Redirecionar para uma página inicial ou de erro
      // Ex: this.router.navigateByUrl('/home');
    }
  }

  voltarTelaInicial(){
    this.router.navigateByUrl('/home');
  }
}
