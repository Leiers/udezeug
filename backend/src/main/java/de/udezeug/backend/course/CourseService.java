package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import de.udezeug.backend.course.dto.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseMapper mapper;
    private final CourseRepository courseRepository;
    private final CourseSearchService searchService;

    public CourseResponse createCourse(CourseCreationRequest request) {
        final Course course = this.courseRepository.save(this.mapper.toCourse(request));
        return this.mapper.toCourseResponse(course);
    }

    public CourseResponse getCourse(UUID id) {
        final Course course = this.courseRepository.findById(id).orElseThrow();
        return this.mapper.toCourseResponse(course);
    }

    public List<CourseResponse> searchCourses(String query) {
        final List<Course> courses = this.searchService.searchCourses(query);
        return courses.stream()
                .map(this.mapper::toCourseResponse)
                .toList();
    }
}
