package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import de.udezeug.backend.course.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CourseMapper {
    Course toCourse(CourseCreationRequest request);

    @Mapping(target = "id", expression = "java(course.isVisible() ? course.getId() : null)")
    @Mapping(target = "description", expression = "java(course.isVisible() ? course.getDescription() : null)")
    CourseResponse toCourseResponse(Course course);
}
