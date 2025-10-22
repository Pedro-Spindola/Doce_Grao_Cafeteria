import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerCafesComponent } from './container-cafes.component';

describe('ContainerCafesComponent', () => {
  let component: ContainerCafesComponent;
  let fixture: ComponentFixture<ContainerCafesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerCafesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContainerCafesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
