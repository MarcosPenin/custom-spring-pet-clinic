package guru.springframework.customspringpetclinic.services.jpa;

import guru.springframework.customspringpetclinic.model.Owner;
import guru.springframework.customspringpetclinic.repositories.OwnerRepository;
import guru.springframework.customspringpetclinic.repositories.PetRepository;
import guru.springframework.customspringpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;
    Owner returnOwner = new Owner();

    @BeforeEach
    void setUp() {
        returnOwner.setId(1L);
        returnOwner.setLastName("Smith");
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownerServiceJpa.findByLastName("Smith");
        assertEquals("Smith", returnOwner.getLastName());
        verify(ownerRepository).findByLastName(any());

    }


    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owner1.setId(1L);
        owner2.setId(2L);
        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerServiceJpa.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }


    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerServiceJpa.findById(1L);

        assertNull(owner);
    }


    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerServiceJpa.save(returnOwner);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }


    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

}
