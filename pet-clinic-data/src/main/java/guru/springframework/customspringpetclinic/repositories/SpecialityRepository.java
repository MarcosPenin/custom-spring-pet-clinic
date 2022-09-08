package guru.springframework.customspringpetclinic.repositories;

import guru.springframework.customspringpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
