import { TestBed } from '@angular/core/testing';

import { PreviewPdfService } from './preview-pdf.service';

describe('PreviewPdfService', () => {
  let service: PreviewPdfService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PreviewPdfService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
