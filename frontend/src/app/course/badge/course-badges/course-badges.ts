import {Component, input} from '@angular/core';
import {badgeConfig} from '../course-badge-model';
import {TitleCasePipe} from '@angular/common';
import {MatTooltip} from '@angular/material/tooltip';
import {MatIcon} from '@angular/material/icon';
import {Course} from '../../course-model';

@Component({
  selector: 'app-course-badges',
  imports: [
    TitleCasePipe,
    MatTooltip,
    MatIcon
  ],
  templateUrl: './course-badges.html',
})
export class CourseBadges {
  readonly course = input.required<Course>()
  protected readonly badgeConfig = badgeConfig;
}
