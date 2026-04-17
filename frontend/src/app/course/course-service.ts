import { inject, Injectable, signal, Signal } from '@angular/core';
import { HttpClient, httpResource } from '@angular/common/http';
import { Course } from './course-model';
import { AppConfig as config } from '../../environments/app-config';
import { ResourceService } from '../http/resource-service';
import { CreateCourseData } from './create-course/create-course';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private readonly baseUrl = config.apiUrl;
  private readonly http = inject(HttpClient);
  private readonly resourceService = inject(ResourceService);

  readonly searchTerm = signal<string>('');

  createCourse(course: CreateCourseData) {
    return this.http.post<Course>(`${this.baseUrl}/v1/course`, course);
  }

  getCourse(id: Signal<string | undefined>) {
    console.log('Getting course: ' + id());
    return httpResource<Course>(() => `${this.baseUrl}/v1/course/${id()}`);
  }

  searchCourses(query: Signal<string>) {
    return this.resourceService.withPreviousValue(
      httpResource<Course[]>(() => `${this.baseUrl}/v1/course/search?query=${query()}`),
    );
  }
}
