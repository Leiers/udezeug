package de.udezeug.backend.course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSearchService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> searchCourses(String query) {
        final SearchSession searchSession = Search.session(entityManager);

        return searchSession.search(Course.class)
                .where(f -> f.match()
                        .fields("name", "name_autocomplete", "description")
                        .matching(query)
                        .fuzzy(1))
                .fetchHits(20);
    }
}
