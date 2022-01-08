import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorAdviseComponent } from './error-advise.component';

describe('ErrorAdviseComponent', () => {
  let component: ErrorAdviseComponent;
  let fixture: ComponentFixture<ErrorAdviseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErrorAdviseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ErrorAdviseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
