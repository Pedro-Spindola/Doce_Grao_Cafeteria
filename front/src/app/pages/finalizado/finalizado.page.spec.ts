import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalizadoPage } from './finalizado.page';

describe('FinalizadoPage', () => {
  let component: FinalizadoPage;
  let fixture: ComponentFixture<FinalizadoPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FinalizadoPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinalizadoPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
