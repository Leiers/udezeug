package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CourseMapperTest {
    private final CourseMapper mapper = Mappers.getMapper(CourseMapper.class);

    @Test
    void shouldMapCourseCreationRequestToCourse() {
        final CourseCreationRequest request = new CourseCreationRequest("Test Course", "Test Description", List.of("Tag 1", "Tag 2"));
        final Course course = this.mapper.toCourse(request);

        assertThat(course.getName()).isEqualTo("Test Course");
        assertThat(course.getDescription()).isEqualTo("Test Description");
        assertThat(course.getTags()).containsExactly("Tag 1", "Tag 2");
        assertThat(course.getId()).isNull();
    }
}
