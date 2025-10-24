import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ItensPedido } from '../models/ItensPedido';
import { Item } from '../models/Item';

@Injectable({
  providedIn: 'root'
})
export class SistemaService {

  // BehaviorSubject guardando o estado do carrinho
  private itensPedidoSubject = new BehaviorSubject<ItensPedido>({ itens: [] });
  itensPedido$ = this.itensPedidoSubject.asObservable();

  constructor() { }

  // METODOS A SEGUIR RELACIONADO AO CARRINHO DE PEDIDOD

  // Adiciona um item ao carrinho
  adicionarItem(item: Item) {
    const current = this.itensPedidoSubject.getValue();
    const itensExistentes = [...current.itens];

    // Se o item já existe, somar quantidade
    const index = itensExistentes.findIndex(i => i.idCafe === item.idCafe);
    if (index >= 0) {
      itensExistentes[index].quantidade += item.quantidade;
    } else {
      itensExistentes.push(item);
    }
    
    // Atualiza o BehaviorSubject
    this.itensPedidoSubject.next({ itens: itensExistentes });
  }

  // Limpar carrinho
  limparCarrinho() {
    this.itensPedidoSubject.next({ itens: [] });
  }

  // Obter o estado atual do carrinho (snapshot)
  obterItens(): ItensPedido {
    return this.itensPedidoSubject.getValue();
  }
}
