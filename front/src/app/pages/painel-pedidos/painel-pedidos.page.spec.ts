import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelPedidosPage } from './painel-pedidos.page';

describe('PainelPedidosPage', () => {
  let component: PainelPedidosPage;
  let fixture: ComponentFixture<PainelPedidosPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PainelPedidosPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PainelPedidosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
