package de.udezeug.backend.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, UUID> {
    List<Course> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);}
