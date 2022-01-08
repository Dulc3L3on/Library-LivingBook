import { TestBed } from '@angular/core/testing';

import { SidenavbarServiceService } from './sidenavbar-service.service';

describe('SidenavbarServiceService', () => {
  let service: SidenavbarServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SidenavbarServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
