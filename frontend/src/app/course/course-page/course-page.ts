import { Component, inject, input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CourseService } from '../course-service';
import { MatProgressSpinner } from '@angular/material/progress-spinner';
import {CourseDetails} from '../course-details/course-details';

@Component({
  selector: 'app-course-page',
  imports: [RouterLink, MatProgressSpinner, CourseDetails],
  templateUrl: './course-page.html',
  styleUrl: './course-page.css',
})
export class CoursePage {
  private readonly courseService = inject(CourseService);
  readonly id = input<string>();
  readonly course = this.courseService.getCourse(this.id);
}
