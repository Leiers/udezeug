package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CourseService service;

    @MockitoBean
    CourseMapper mapper;

    @Test
    void shouldReturnCourse() throws Exception {
        final Course course = new Course(UUID.randomUUID(), "Course name", "Course description", List.of("Tag 1",
                "Tag 2"), true);
        final CourseResponse response = new CourseResponse(course.getId(), course.getName(), course.getDescription(),
                course.getTags(), course.isVisible());

        when(service.getCourse(course.getId())).thenReturn(response);
        when(mapper.toCourseResponse(course)).thenReturn(response);

        mockMvc.perform(get("/v1/course/{id}", course.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(course.getId().toString()))
                .andExpect(jsonPath("$.name").value(course.getName()))
                .andExpect(jsonPath("$.description").value(course.getDescription()))
                .andExpect(jsonPath("$.visible").value(true))
                .andExpect(jsonPath("$.tags").isArray())
                .andExpect(jsonPath("$.tags[0]").value("Tag 1"))
                .andExpect(jsonPath("$.tags[1]").value("Tag 2"));
    }

    @Test
    void shouldReturnPrivateCourse() throws Exception {
        final Course course = new Course(UUID.randomUUID(), "Course name", "Course description", List.of("Tag 1",
                "Tag 2"), false);
        final CourseResponse response = new CourseResponse(null, course.getName(), null, null, false);

        when(service.getCourse(course.getId())).thenReturn(response);
        when(mapper.toCourseResponse(course)).thenReturn(response);

        mockMvc.perform(get("/v1/course/{id}", course.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.name").value(course.getName()))
                .andExpect(jsonPath("$.description").doesNotExist())
                .andExpect(jsonPath("$.visible").value(false))
                .andExpect(jsonPath("$.tags").doesNotExist());
    }
}
