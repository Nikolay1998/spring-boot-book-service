package ssau.esa.lr.repos;

import org.springframework.data.repository.CrudRepository;
import ssau.esa.lr.entity.Event;


public interface EventRepo extends CrudRepository<Event, Long> {
}
