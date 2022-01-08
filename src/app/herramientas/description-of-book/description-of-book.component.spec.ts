import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DescriptionOfBookComponent } from './description-of-book.component';

describe('DescriptionOfBookComponent', () => {
  let component: DescriptionOfBookComponent;
  let fixture: ComponentFixture<DescriptionOfBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DescriptionOfBookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DescriptionOfBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
