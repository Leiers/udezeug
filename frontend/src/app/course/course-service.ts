import {Injectable} from '@angular/core';
import {httpResource} from '@angular/common/http';
import {Course} from './course-model';
import { AppConfig as config } from '../../environments/app-config';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  private readonly baseUrl = config.apiUrl

  getCourse(id: string) {
    return httpResource<Course>(() => `${this.baseUrl}/v1/course/${id}`);
  }
}
