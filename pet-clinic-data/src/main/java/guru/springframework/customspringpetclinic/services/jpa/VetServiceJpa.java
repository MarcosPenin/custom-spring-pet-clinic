package guru.springframework.customspringpetclinic.services.jpa;

import guru.springframework.customspringpetclinic.model.Vet;
import guru.springframework.customspringpetclinic.repositories.VetRepository;
import guru.springframework.customspringpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetServiceJpa implements VetService {

    private final VetRepository vetRepository;

    public VetServiceJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

}
