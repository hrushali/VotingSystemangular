import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VotescomponantComponent } from './votescomponant.component';

describe('VotescomponantComponent', () => {
  let component: VotescomponantComponent;
  let fixture: ComponentFixture<VotescomponantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VotescomponantComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VotescomponantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
