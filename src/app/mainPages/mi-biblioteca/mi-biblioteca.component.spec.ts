import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiBibliotecaComponent } from './mi-biblioteca.component';

describe('MiBibliotecaComponent', () => {
  let component: MiBibliotecaComponent;
  let fixture: ComponentFixture<MiBibliotecaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiBibliotecaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiBibliotecaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
