package nobel.spring.petclinic.services.springdatajpa;

import nobel.spring.petclinic.model.Owner;
import nobel.spring.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findById() {
        Owner owner = new Owner();
        owner.setId(1l);

        Mockito.when(ownerRepository.findById(1l)).thenReturn(Optional.of(owner));
        Mockito.when(ownerRepository.findById(2l)).thenReturn(Optional.empty());

        Owner foundOwner = ownerSDJpaService.findById(1l);
        Owner notFoundOwner = ownerSDJpaService.findById(2l);
        Mockito.verify(ownerRepository, Mockito.times(2)).findById(any());

        assertEquals(1, foundOwner.getId());
        assertNull(notFoundOwner);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().firstName("Ahmed").build();
        owner.setId(1l);

        Mockito.when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);

        Mockito.verify(ownerRepository, Mockito.times(1)).save(any());
        assertEquals(1, savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().firstName("Ahmed").build());
        owners.add(Owner.builder().firstName("some thing else").build());

        Mockito.when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(2, ownerSDJpaService.findAll().size());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(new Owner());
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1l);
        Mockito.verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner returnedOwner = Owner.builder().lastName("Nabil").build();

        Mockito.when(ownerRepository.findByLastName("Nabil")).thenReturn(returnedOwner);

        Owner nabil = ownerSDJpaService.findByLastName("Nabil");
        Mockito.verify(ownerRepository, Mockito.times(1)).findByLastName(any());

        assertEquals("Nabil", nabil.getLastName());
    }
}