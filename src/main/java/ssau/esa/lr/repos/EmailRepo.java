package ssau.esa.lr.repos;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.lr.entity.Email;

public interface EmailRepo extends CrudRepository<Email, Long> {
}
