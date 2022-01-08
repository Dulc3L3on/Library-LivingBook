import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EspecificacionCreacionComponent } from './especificacion-creacion.component';

describe('EspecificacionCreacionComponent', () => {
  let component: EspecificacionCreacionComponent;
  let fixture: ComponentFixture<EspecificacionCreacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EspecificacionCreacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EspecificacionCreacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
