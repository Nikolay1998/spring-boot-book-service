package ssau.esa.lr.repos;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.lr.entity.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
}
