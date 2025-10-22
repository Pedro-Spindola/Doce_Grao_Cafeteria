import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerApresentacaoComponent } from './container-apresentacao.component';

describe('ContainerApresentacaoComponent', () => {
  let component: ContainerApresentacaoComponent;
  let fixture: ComponentFixture<ContainerApresentacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerApresentacaoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContainerApresentacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
