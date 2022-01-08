import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreacionesComponent } from './creaciones.component';

describe('CreacionesComponent', () => {
  let component: CreacionesComponent;
  let fixture: ComponentFixture<CreacionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreacionesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreacionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
