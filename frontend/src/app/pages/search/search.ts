import {Component, inject} from '@angular/core';
import {MatIcon} from '@angular/material/icon';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {toSignal} from '@angular/core/rxjs-interop';
import {debounceTime, distinctUntilChanged, tap} from 'rxjs';
import {map} from 'rxjs/operators';
import {CourseService} from '../../course/course-service';
import {MatCard, MatCardContent, MatCardSubtitle, MatCardTitle} from '@angular/material/card';
import {RouterLink} from '@angular/router';
import {MatProgressSpinner} from '@angular/material/progress-spinner';
import {MatButton} from '@angular/material/button';
import {MatTooltip} from '@angular/material/tooltip';

@Component({
  selector: 'app-search',
  imports: [
    MatIcon,
    ReactiveFormsModule,
    MatCard,
    MatCardTitle,
    MatCardSubtitle,
    RouterLink,
    MatProgressSpinner,
    MatButton,
    MatCardContent,
    MatTooltip,
  ],
  templateUrl: './search.html',
  styleUrl: './search.css',
})
export class Search {
  private readonly courseService = inject(CourseService);

  readonly searchControl = new FormControl(this.courseService.searchTerm())
  readonly rawSearchTerm = toSignal(
    this.searchControl.valueChanges.pipe(
      map(v => (v ?? '').trim()),
      debounceTime(400),
      distinctUntilChanged(),
      tap((v) => this.courseService.searchTerm.set(v))
    ),
    {initialValue: this.searchControl.value ?? ''}
  );
  readonly courses = this.courseService.searchCourses(this.rawSearchTerm)
}
