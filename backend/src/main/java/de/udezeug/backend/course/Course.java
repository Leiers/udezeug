package de.udezeug.backend.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.DocumentId;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

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
}
