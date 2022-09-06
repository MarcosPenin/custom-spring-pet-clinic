package guru.springframework.customspringpetclinic.services;

import guru.springframework.customspringpetclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet,Long> {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
