package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;


public class CourseMapperTest {
    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    @Test
    void shouldMapCourseCreationRequestToCourse() {
        final CourseCreationRequest request = new CourseCreationRequest("Test Course", "Test Description");
        final Course course = this.mapper.toCourse(request);

        assertThat(course.getName()).isEqualTo("Test Course");
        assertThat(course.getDescription()).isEqualTo("Test Description");
        assertThat(course.getId()).isNull();
    }
}
