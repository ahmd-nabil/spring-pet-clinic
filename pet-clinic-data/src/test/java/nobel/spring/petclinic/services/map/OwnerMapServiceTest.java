package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        // we used actual implementation(Not mocks) because it is simple services
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        Owner owner = Owner.builder().firstName("Ahmed").lastName("Nabil").build();
        owner.setId(1L);
        ownerMapService.save(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);
        assertEquals(1L, owner.getId());
        Owner notFoundOwner = ownerMapService.findById(7L);
        assertNull(notFoundOwner);
    }

    @Test
    void saveGivenId() {
        Owner owner2 = Owner.builder().firstName("owner2FirstName").lastName("owner2LastName").build();
        owner2.setId(2L);
        ownerMapService.save(owner2);
        assertEquals(2, ownerMapService.findById(2L).getId());
    }

    @Test
    void saveWithoutId() {
        Owner owner3 = Owner.builder().firstName("owner3FirstName").lastName("owner3LastName").build();
        ownerMapService.save(owner3);
        assertNotNull(owner3);
        assertNotNull(owner3.getId());
        assertNotEquals(1L, owner3.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(0, ownerMapService.findAll());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("Nabil");
        assertEquals("Nabil", owner.getLastName());

        Owner ownerNotFound = ownerMapService.findByLastName("NotFoundName");
        assertNull(ownerNotFound);
    }
}