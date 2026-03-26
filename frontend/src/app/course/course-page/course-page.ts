import {Component, computed, inject} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {CourseService} from '../course-service';

@Component({
  selector: 'app-course-page',
  imports: [
    RouterLink
  ],
  templateUrl: './course-page.html',
  styleUrl: './course-page.css',
})
export class CoursePage {
  private readonly activeRoute = inject(ActivatedRoute);
  private readonly courseService = inject(CourseService);
  private readonly id = computed(() => this.activeRoute.snapshot.paramMap.get('id')!)
  readonly course = this.courseService.getCourse(this.id())
}
