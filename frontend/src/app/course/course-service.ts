import {Injectable} from '@angular/core';
import {httpResource} from '@angular/common/http';
import {Course} from './course-model';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private readonly baseUrl = 'http://localhost:8080/v1/course/'

  getCourse(id: string) {
    return httpResource<Course>(() => `${this.baseUrl}${id}`);
  }
}
