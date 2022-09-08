package guru.springframework.customspringpetclinic.repositories;

import guru.springframework.customspringpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
