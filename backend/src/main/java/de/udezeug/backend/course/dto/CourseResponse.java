package de.udezeug.backend.course.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CourseResponse(
        UUID id,
        String name,
        String description,
        List<String> tags,
        Boolean visible,
        LocalDate examDate,
        String moodle
) {
}
