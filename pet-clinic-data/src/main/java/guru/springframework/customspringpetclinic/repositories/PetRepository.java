package guru.springframework.customspringpetclinic.repositories;

import guru.springframework.customspringpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
