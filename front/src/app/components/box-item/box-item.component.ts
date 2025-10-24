import { Component, Input} from '@angular/core';
import { ButtonPadraoComponent } from "../button-padrao/button-padrao.component";
import { CommonModule } from '@angular/common';
import { CafeResponse } from '../../models/CafeResponse';
import { SistemaService } from '../../services/sistema.service';
import { Item } from '../../models/Item';
@Component({
  selector: 'app-box-item',
  imports: [CommonModule, ButtonPadraoComponent],
  templateUrl: './box-item.component.html',
  styleUrl: './box-item.component.scss'
})
export class BoxItemComponent{
  urlImagem: String = 'cafe_model.png';
  @Input() cafeParaBox!: CafeResponse;
  quantidade: number = 0;

  constructor(private sistemaService: SistemaService){}

  adicionar(){
    if(this.quantidade > 0){
        var item: Item = {
        idCafe: this.cafeParaBox.id,
        quantidade: this.quantidade
      };
      this.sistemaService.adicionarItem(item);
      this.quantidade = 0;
    }else{
      console.log("Quantidade deverá ser maior do que 0.");
    }
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