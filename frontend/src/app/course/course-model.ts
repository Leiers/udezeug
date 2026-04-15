import { CourseBadge } from './badge/course-badge-model';

export interface Course {
  id: string;
  name: string;
  description: string;
  visible: boolean;
  badges?: CourseBadge[];
  examDate: string;
  moodle: string;
}
