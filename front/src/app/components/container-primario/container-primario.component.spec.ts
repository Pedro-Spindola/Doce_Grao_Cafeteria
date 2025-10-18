import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerPrimarioComponent } from './container-primario.component';

describe('ContainerPrimarioComponent', () => {
  let component: ContainerPrimarioComponent;
  let fixture: ComponentFixture<ContainerPrimarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerPrimarioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContainerPrimarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
