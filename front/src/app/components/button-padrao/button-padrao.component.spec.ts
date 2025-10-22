import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonPadraoComponent } from './button-padrao.component';

describe('ButtonPadraoComponent', () => {
  let component: ButtonPadraoComponent;
  let fixture: ComponentFixture<ButtonPadraoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ButtonPadraoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonPadraoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
