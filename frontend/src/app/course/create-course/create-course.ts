import {Component, inject, signal} from '@angular/core';
import {MatFormField, MatInput, MatLabel} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import {form, FormField, maxLength, minLength, required} from '@angular/forms/signals';
import {CourseService} from '../course-service';
import {Router} from '@angular/router';
import {MatProgressSpinner} from '@angular/material/progress-spinner';
import {MatSlideToggle} from '@angular/material/slide-toggle';

@Component({
  selector: 'app-create-course',
  imports: [
    MatFormField,
    MatLabel,
    MatInput,
    MatButton,
    FormField,
    MatProgressSpinner,
    MatSlideToggle,
  ],
  templateUrl: './create-course.html',
  styleUrl: './create-course.css',
})
export class CreateCourse {
  private readonly courseService = inject(CourseService)
  private readonly router = inject(Router)

  protected readonly createCourseModel = signal<CreateCourseData>({name: '', description: '', visible: true})
  protected readonly createCourseForm = form(this.createCourseModel, (schema) => {
    required(schema.name)
    minLength(schema.name, 3)
    maxLength(schema.name, 255)
    required(schema.description)
  })
  protected readonly isLoading = signal<boolean>(false)

  protected onCreateCourse(event: SubmitEvent) {
    event.preventDefault()

    this.isLoading.set(true)

    this.courseService.createCourse(this.createCourseModel()).subscribe((data) => {
      const courseId = data.id
      const route = courseId ? ["course", courseId] : ["/"]
      this.router.navigate(route).then(() => this.isLoading.set(false))
    })
  }
}

export interface CreateCourseData {
  name: string,
  description: string
  visible: boolean
}
