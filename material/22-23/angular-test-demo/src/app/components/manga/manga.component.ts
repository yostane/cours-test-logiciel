import { Component } from '@angular/core';
import { MathService } from 'src/app/services/math.service';

@Component({
  selector: 'app-manga',
  templateUrl: './manga.component.html',
  styleUrls: ['./manga.component.css'],
})
export class MangaComponent {
  sum = 0;

  constructor(private readonly mathService: MathService) {
    this.sum = mathService.add(10, 30);
  }
}
