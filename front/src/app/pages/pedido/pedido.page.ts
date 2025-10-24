import { Component, OnInit } from '@angular/core';
import { ProdutosService } from '../../services/produtos.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ButtonPadraoComponent } from "../../components/button-padrao/button-padrao.component";
import { SistemaService } from '../../services/sistema.service';
import { combineLatest, map, Observable, of } from 'rxjs';
import { ItemDetalhado } from '../../models/ItemDetalhado';
import { Item } from '../../models/Item';
import { CafeResponse } from '../../models/CafeResponse';
import { PedidoService } from '../../services/pedido.service';
import { Router } from '@angular/router';
import { PagamentoService } from '../../services/pagamento.service';
import { PagamentoRequestSimples } from '../../models/PagamentoRequestSimples';
import { WebSocketService } from '../../services/web-socket.service';

@Component({
  selector: 'app-pedido',
  imports: [CommonModule, FormsModule],
  templateUrl: './pedido.page.html',
  styleUrl: './pedido.page.scss'
})
export class PedidoPage implements OnInit {
  // Observable para a lista de itens a ser exibida
  itensPedidoExibicao$!: Observable<ItemDetalhado[]>;

  // Observable para o valor total do pedido
  totalPedido$!: Observable<number>;

  constructor(
    private sistemaService: SistemaService,
    private produtosService: ProdutosService,
    private pedidoService: PedidoService,
    private pagamentoService: PagamentoService,
    private webSocketService: WebSocketService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // PASSO A: Preparar o stream de ITENS DO PEDIDO (ID e QUANTIDADE)
    const itensPedido$ = this.sistemaService.itensPedido$.pipe(
      map(pedido => pedido.itens) // Retorna Observable<Item[]>
    );

    // PASSO B: Preparar o stream de PRODUTOS (NOME e PREÇO)
    // O 'of' agora está importado e funcional.
    const produtos$ = of(this.produtosService.obterCafes()); // Retorna Observable<CafeResponse[]>

    // PASSO C: COMBINAR E TRANSFORMAR OS DADOS para exibição
    this.itensPedidoExibicao$ = combineLatest([
      itensPedido$,
      produtos$,
    ]).pipe(
      // TIPAGEM EXPLÍCITA CORRIGIDA: Resolve todos os erros de tupla e 'any'
      map(([itensPedido, produtos]: [Item[], CafeResponse[]]) => { 
        
        return itensPedido.map(itemPedido => {
          // O TypeScript agora sabe os tipos, e o 'p' está tipado corretamente
          const produto = produtos.find((p: CafeResponse) => p.id === itemPedido.idCafe); 

          if (!produto) {
            console.warn(`Produto com ID ${itemPedido.idCafe} não encontrado!`);
            return null as any; 
          }

          const subTotal = itemPedido.quantidade * produto.valor;

          return {
            nomeCafe: produto.nome,
            quantidade: itemPedido.quantidade,
            precoUnitario: produto.valor,
            subTotal: subTotal,
          } as ItemDetalhado;
        })
        .filter(item => item !== null) as ItemDetalhado[];
      })
    );

    // PASSO D: CALCULAR O TOTAL
    this.totalPedido$ = this.itensPedidoExibicao$.pipe(
      // O 'itensExibicao' agora é tipado como ItemDetalhado[]
      map(itensExibicao => 
        itensExibicao.reduce((acumulador, item) => acumulador + item.subTotal, 0)
      )
    );
  }

  fazerPedido(): void {
    const pedidoAtual = this.sistemaService.obterItens();

    if (pedidoAtual.itens.length === 0) {
      console.warn('O carrinho está vazio. Adicione itens antes de fazer o pedido.');
      return;
    }

    this.pedidoService.create(pedidoAtual).subscribe({
      next: (resposta) => {
        console.log('Pedido enviado com sucesso! ID do Pedido:', resposta.id);
        this.pagamentoService.setIdPagamento(resposta.id);
        this.sistemaService.limparCarrinho();
        this.router.navigateByUrl('/pagamento');
        this.pedidoService.atualizarListas();
        this.webSocketService.connect();
      },
      error: (erro) => {
        console.error('Erro ao enviar o pedido:', erro);
      }
    });
  }
}
