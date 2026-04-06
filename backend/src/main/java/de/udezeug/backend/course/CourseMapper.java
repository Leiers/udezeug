package de.udezeug.backend.course;

import de.udezeug.backend.course.dto.CourseCreationRequest;
import de.udezeug.backend.course.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CourseMapper {
    @Mapping(target = "tags", expression = "java(mapTags(request.tags()))")
    Course toCourse(CourseCreationRequest request);

    @Mapping(target = "id", expression = "java(course.isVisible() ? course.getId() : null)")
    @Mapping(target = "description", expression = "java(course.isVisible() ? course.getDescription() : null)")
    @Mapping(target = "tags", expression = "java(course.isVisible() ? course.getTags() : null)")
    CourseResponse toCourseResponse(Course course);

    default List<String> mapTags(String tags) {
        if (tags == null || tags.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(tags.split(","))
                .map(String::trim)
                .filter(tag -> !tag.isEmpty())
                .toList();
    }
}
