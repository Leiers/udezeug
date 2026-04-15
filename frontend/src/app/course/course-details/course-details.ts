import { Component, input, signal } from '@angular/core';
import { Course } from '../course-model';
import { MatIcon } from '@angular/material/icon';
import { CourseBadges } from '../badge/course-badges/course-badges';
import { DatePipe } from '@angular/common';
import { MatButton } from '@angular/material/button';
import { MatTooltip } from '@angular/material/tooltip';

@Component({
  selector: 'app-course-details',
  imports: [MatIcon, CourseBadges, DatePipe, MatButton, MatTooltip],
  templateUrl: './course-details.html',
  styleUrl: './course-details.css',
})
export class CourseDetails {
  readonly course = input.required<Course>();
  readonly descriptionExpanded = signal<boolean>(false);

  toggleDescription() {
    this.descriptionExpanded.update((v) => !v);
  }
}
