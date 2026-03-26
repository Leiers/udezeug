package de.udezeug.backend.course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    @Test
    void shouldSaveCourse() {
        final Course course = this.repository.save(new Course(null, "Test Course", "Test Description"));
        final var foundCourse = this.repository.findById(course.getId());

        assertThat(foundCourse).isPresent();
        assertThat(foundCourse.get().getId()).isEqualTo(course.getId());
        assertThat(foundCourse.get().getName()).isEqualTo("Test Course");
        assertThat(foundCourse.get().getDescription()).isEqualTo("Test Description");
    }
}
