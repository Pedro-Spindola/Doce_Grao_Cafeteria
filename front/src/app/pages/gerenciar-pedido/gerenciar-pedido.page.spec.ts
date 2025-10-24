import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciarPedidoPage } from './gerenciar-pedido.page';

describe('GerenciarPedidoPage', () => {
  let component: GerenciarPedidoPage;
  let fixture: ComponentFixture<GerenciarPedidoPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GerenciarPedidoPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GerenciarPedidoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
