package de.udezeug.backend.course;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.DocumentId;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Indexed
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @DocumentId
    @GeneratedValue
    private UUID id;

    @FullTextField(analyzer = "german")
    private String name;

    @FullTextField(analyzer = "german")
    @FullTextField(name = "name_autocomplete", analyzer = "autocomplete", searchAnalyzer = "autocomplete_query")
    private String description;

    @FullTextField(analyzer = "german")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "course_tags", joinColumns = @JoinColumn(name = "course_id"))
    private List<String> tags;
}
