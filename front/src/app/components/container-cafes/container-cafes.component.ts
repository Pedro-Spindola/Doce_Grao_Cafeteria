import { Component, OnInit } from '@angular/core';
import { Cafes, ProdutosService } from '../../services/produtos.service';
import { BoxItemComponent } from "../box-item/box-item.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-container-cafes',
  imports: [BoxItemComponent, CommonModule],
  templateUrl: './container-cafes.component.html',
  styleUrl: './container-cafes.component.scss'
})
export class ContainerCafesComponent implements OnInit {
  cafes: Cafes[] = [];

  constructor(private produtosService: ProdutosService){}

  ngOnInit(): void {
      this.produtosService.findAll().subscribe({
      next: (dadosDaApi) => {
        this.cafes = dadosDaApi;
        console.log('Cafés carregados com sucesso:', this.cafes);
      },
      error: (erro) => {
        console.error('Falha ao carregar a lista de cafés.', erro);
      }
    });
  }
}
