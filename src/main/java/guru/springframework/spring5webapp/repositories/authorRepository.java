package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.author;
import org.springframework.data.repository.CrudRepository;

public interface authorRepository extends CrudRepository<author, Long> {
}
