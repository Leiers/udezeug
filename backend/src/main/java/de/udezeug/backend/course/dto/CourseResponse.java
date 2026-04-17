package de.udezeug.backend.course.dto;

import de.udezeug.backend.course.badge.CourseBadge;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CourseResponse(
        UUID id,
        String name,
        String description,
        List<String> tags,
        Boolean visible,
        List<CourseBadge> badges,
        LocalDate examDate,
        String moodle
) {
}
