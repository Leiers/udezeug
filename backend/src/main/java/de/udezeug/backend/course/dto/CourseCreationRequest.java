package de.udezeug.backend.course.dto;

import jakarta.validation.constraints.Size;

import java.util.List;

public record CourseCreationRequest(
        @Size(min = 3, max = 255)
        String name,
        String description,
        List<String> tags
) {
}
