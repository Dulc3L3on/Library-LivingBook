import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreviewPDFComponent } from './preview-pdf.component';

describe('PreviewPDFComponent', () => {
  let component: PreviewPDFComponent;
  let fixture: ComponentFixture<PreviewPDFComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreviewPDFComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreviewPDFComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
