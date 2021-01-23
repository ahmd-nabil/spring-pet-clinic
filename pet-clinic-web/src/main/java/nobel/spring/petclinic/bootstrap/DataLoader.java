package nobel.spring.petclinic.bootstrap;

import nobel.spring.petclinic.model.*;
import nobel.spring.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        PetType type1 = new PetType();
        type1.setName("Dog");
        PetType savedDogType = petTypeService.save(type1);

        PetType type2 = new PetType();
        type2.setName("Cat");
        PetType savedCatType = petTypeService.save(type2);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");


        Owner owner1 = new Owner();
        owner1.setFirstName("Ahmed");
        owner1.setLastName("Nabil");
        owner1.setAddress("123 Somewhere");
        owner1.setCity("Some City");
        owner1.setTelephone("123123123");

        Pet pet1 = new Pet();
        pet1.setName("Pet1");
        pet1.setPetType(type1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ali");
        owner2.setLastName("Ali");
        owner2.setAddress("456 Some where else");
        owner2.setCity("Another City");
        owner2.setTelephone("456456456");

        Pet pet2 = new Pet();
        pet2.setName("Pet2");
        pet2.setPetType(type2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        ownerService.save(owner2);
        System.out.println("Loaded Owners ...");

        Visit visit1 = new Visit();
        visit1.setPet(pet1);
        visit1.setDescription("Some Visit");
        visit1.setDate(LocalDate.now());
        visitService.save(visit1);

        System.out.println("Loaded Visits...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
