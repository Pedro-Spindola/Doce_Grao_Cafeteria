import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoPagamento } from '../../models/enums/TipoPagamento';
import { PagamentoRequestSimples } from '../../models/PagamentoRequestSimples';
import { PagamentoService } from '../../services/pagamento.service';
import { PedidoResponse } from '../../models/PedidoResponse';

@Component({
  selector: 'app-pagamento',
  imports: [],
  templateUrl: './pagamento.page.html',
  styleUrl: './pagamento.page.scss'
})
export class PagamentoPage implements OnInit{
  tipoEscolhido!: TipoPagamento;
  TipoPagamento = TipoPagamento;
  pagamentoRequest!: PagamentoRequestSimples;

  constructor(private router: Router, private pagamentoService: PagamentoService) {}

  ngOnInit(): void {

  }

  EscolherMetodo(tipo: TipoPagamento): void {
    this.tipoEscolhido = tipo;
    this.pagamentoRequest = {
        id_Pedido: this.pagamentoService.getIdPagamento(),
        tipoPagamento: this.tipoEscolhido
    };

    // 💥 CORREÇÃO 1: Assinar o Observable
    this.pagamentoService.confirmarPagamento(this.pagamentoRequest).subscribe({
        next: (pedidoResponse: PedidoResponse) => {
            // O código de navegação deve estar aqui DENTRO
            
            // CORREÇÃO 2: Passar o objeto PedidoResponse usando history.state
            this.router.navigateByUrl('/finalizado', { 
                state: { 
                    pedidoFinalizado: pedidoResponse // Chave customizada para o dado
                } 
            });
            
            console.log('Método de pagamento escolhido e pedido enviado:', this.pagamentoRequest);
        },
        error: (erro) => {
            console.error('Erro ao confirmar pagamento:', erro);
            // Lógica para lidar com erro, como mostrar uma mensagem ao usuário
        }
    });
  }
}
