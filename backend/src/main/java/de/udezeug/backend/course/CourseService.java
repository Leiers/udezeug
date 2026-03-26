package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import de.udezeug.backend.course.dto.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseMapper mapper;
    private final CourseRepository courseRepository;

    public CourseResponse createCourse(CourseCreationRequest request) {
        final Course course = this.courseRepository.save(this.mapper.toCourse(request));
        return this.mapper.toCourseResponse(course);
    }

    public CourseResponse getCourse(UUID id) {
        final Course course = this.courseRepository.findById(id).orElseThrow();
        return this.mapper.toCourseResponse(course);
    }
}
