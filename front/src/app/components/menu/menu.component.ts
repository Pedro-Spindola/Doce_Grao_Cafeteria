import { Component, OnDestroy, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { SistemaService } from '../../services/sistema.service';
import { ItensPedido } from '../../models/ItensPedido';

@Component({
  selector: 'app-menu',
  imports: [RouterModule],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent implements OnInit, OnDestroy {
  quantidadeItens: number = 0;
  
  private subscription!: Subscription;

  constructor(private sistemaService: SistemaService) {}

  ngOnInit() {
    // Inscreve para receber atualizações do BehaviorSubject
    this.subscription = this.sistemaService.itensPedido$.subscribe((itensPedido: ItensPedido) => {
      // Atualiza quantidadeItens com o tamanho do array de itens
      this.quantidadeItens = itensPedido.itens.length;
    });
  }

  ngOnDestroy() {
    // Evita vazamento de memória
    this.subscription.unsubscribe();
  }

}
