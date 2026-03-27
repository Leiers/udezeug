import {
  inject,
  Injectable,
  Signal
} from '@angular/core';
import {httpResource} from '@angular/common/http';
import {Course} from './course-model';
import { AppConfig as config } from '../../environments/app-config';
import {ResourceService} from '../http/resource-service';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private readonly baseUrl = config.apiUrl
  private readonly resourceService = inject(ResourceService)

  getCourse(id: string) {
    return httpResource<Course>(() => `${this.baseUrl}/v1/course/${id}`);
  }

  searchCourses(query: Signal<string>) {
    return this.resourceService.withPreviousValue(httpResource<Course[]>(() => `${this.baseUrl}/v1/course/search?query=${query()}`));
  }
}
