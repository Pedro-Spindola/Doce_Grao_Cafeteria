import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button-padrao',
  imports: [],
  templateUrl: './button-padrao.component.html',
  styleUrl: './button-padrao.component.scss'
})
export class ButtonPadraoComponent {
  @Input() nome: string = '';
  @Output() acao: EventEmitter<void> = new EventEmitter();

  onClick() {
    this.acao.emit();
  }
}
