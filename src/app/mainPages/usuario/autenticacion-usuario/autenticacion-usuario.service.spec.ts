import { TestBed } from '@angular/core/testing';

import { AutenticacionUsuarioService } from './autenticacion-usuario.service';

describe('AutenticacionUsuarioService', () => {
  let service: AutenticacionUsuarioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AutenticacionUsuarioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
