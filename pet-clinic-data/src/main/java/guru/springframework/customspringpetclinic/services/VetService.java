package guru.springframework.customspringpetclinic.services;

import guru.springframework.customspringpetclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long> {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
