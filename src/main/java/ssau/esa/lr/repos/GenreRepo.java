package ssau.esa.lr.repos;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.lr.entity.Genre;

public interface GenreRepo extends CrudRepository<Genre, Long> {
}
