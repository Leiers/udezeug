package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import de.udezeug.backend.course.dto.CourseResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class CourseMapperTest {
    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    @Test
    void shouldMapCourseCreationRequestToCourse() {
        final CourseCreationRequest request = new CourseCreationRequest("Test Course", "Test Description", "Tag 1, " +
                "Tag 2", true, LocalDate.now(), "https://moodle.example.org");
        final Course course = this.mapper.toCourse(request);

        assertThat(course.getName()).isEqualTo(request.name());
        assertThat(course.getDescription()).isEqualTo(request.description());
        assertThat(course.getTags()).size().isEqualTo(2);
        assertThat(course.isVisible()).isEqualTo(request.visible());
        assertThat(course.getId()).isNull();
        assertThat(course.getExamDate()).isEqualTo(request.examDate());
        assertThat(course.getMoodle()).isEqualTo(request.moodle());
    }

    @Test
    void shouldMapCourseCreationRequestToCoursePrivate() {
        final CourseCreationRequest request = new CourseCreationRequest("Test Course", "Test Description", "Tag 1, " +
                "Tag 2", false, LocalDate.now(), "https://moodle.example.org");
        final Course course = this.mapper.toCourse(request);
        final CourseResponse courseResponse = this.mapper.toCourseResponse(course);

        assertThat(courseResponse.id()).isNull();
        assertThat(courseResponse.name()).isEqualTo(request.name());
        assertThat(courseResponse.description()).isNull();
        assertThat(courseResponse.tags()).isNullOrEmpty();
        assertThat(courseResponse.visible()).isEqualTo(request.visible());
        assertThat(courseResponse.examDate()).isNull();
        assertThat(courseResponse.moodle()).isNullOrEmpty();
    }
}
