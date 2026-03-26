package de.udezeug.backend.course.dto;

import jakarta.validation.constraints.Size;

public record CourseCreationRequest(
        @Size(min = 3, max = 255)
        String name,
        String description
) {
}
