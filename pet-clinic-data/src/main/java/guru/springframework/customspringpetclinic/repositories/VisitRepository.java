package guru.springframework.customspringpetclinic.repositories;

import guru.springframework.customspringpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
