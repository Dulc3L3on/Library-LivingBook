import { TestBed } from '@angular/core/testing';

import { MiBibliotecaService } from './mi-biblioteca.service';

describe('MiBibliotecaService', () => {
  let service: MiBibliotecaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MiBibliotecaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
