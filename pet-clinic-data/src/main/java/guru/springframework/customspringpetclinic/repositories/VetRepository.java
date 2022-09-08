package guru.springframework.customspringpetclinic.repositories;

import guru.springframework.customspringpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
