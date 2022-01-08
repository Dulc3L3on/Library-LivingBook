import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BannerPresentacionComponent } from './banner-presentacion.component';

describe('BannerPresentacionComponent', () => {
  let component: BannerPresentacionComponent;
  let fixture: ComponentFixture<BannerPresentacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BannerPresentacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BannerPresentacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
