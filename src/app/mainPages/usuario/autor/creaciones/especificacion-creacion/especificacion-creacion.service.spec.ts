import { TestBed } from '@angular/core/testing';

import { EspecificacionCreacionService } from './especificacion-creacion.service';

describe('EspecificacionCreacionService', () => {
  let service: EspecificacionCreacionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EspecificacionCreacionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
