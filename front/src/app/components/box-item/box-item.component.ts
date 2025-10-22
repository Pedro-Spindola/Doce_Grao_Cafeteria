import { Component, Input, Output, EventEmitter } from '@angular/core';
import { ButtonPadraoComponent } from "../button-padrao/button-padrao.component";
import { CommonModule } from '@angular/common';
import { Cafes } from '../../services/produtos.service';
@Component({
  selector: 'app-box-item',
  imports: [CommonModule, ButtonPadraoComponent],
  templateUrl: './box-item.component.html',
  styleUrl: './box-item.component.scss'
})
export class BoxItemComponent{
  urlImagem: String = 'cafe_model.png';
  @Input() cafe!: Cafes;
  @Output() adicionarPedido: EventEmitter<void> = new EventEmitter();
  quantidade: number = 0;

  adicionar(){
    this.adicionarPedido.emit();
  }

  btn_aumentar(){
    this.quantidade++;
    console.log("Aumentar para " + this.quantidade);
  }

  btn_diminuir(){
    if(this.quantidade <= 0) this.quantidade = 0;
    else this.quantidade--; 
    console.log("Diminuir para " + this.quantidade );
  }

}


/*
export class TabelaPadraoComponent implements OnInit {
  contatos: Contato[] = [];

  constructor(private contatoService: ContatoService) {}

  ngOnInit(): void {
    this.contatoService.findAll().subscribe({
      next: (dados) => {
        this.contatos = dados;
      },
      error: (erro) => {

        console.error('Erros ao buscar contatos: ', erro);
      }
    });
  }
}
*/