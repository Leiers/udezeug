package de.udezeug.backend.course.badge;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/course/badge")
public class CourseBadgeController {
    @GetMapping
    public ResponseEntity<List<CourseBadge>> getAllBadges() {
        return ResponseEntity.ok(Arrays.stream(CourseBadge.values()).toList());
    }
}
