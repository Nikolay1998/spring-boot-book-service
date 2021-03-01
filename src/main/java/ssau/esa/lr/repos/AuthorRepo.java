package ssau.esa.lr.repos;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.lr.entity.Author;

public interface  AuthorRepo extends CrudRepository<Author, Long> {
}
