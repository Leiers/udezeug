import { Routes } from '@angular/router';
import {Home} from './pages/home/home';
import {Search} from './pages/search/search';
import {CoursePage} from './course/course-page/course-page';
import {CreateCourse} from './course/create-course/create-course';

export const routes: Routes = [
  { path: 'home', component: Home },
  { path: 'search', component: Search},
  { path: 'course/new', component: CreateCourse },
  { path: 'course/:id', component: CoursePage },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home', pathMatch: 'full' },
];
