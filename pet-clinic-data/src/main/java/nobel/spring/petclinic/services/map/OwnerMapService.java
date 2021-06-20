package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Owner;
import nobel.spring.petclinic.services.OwnerService;
import nobel.spring.petclinic.services.PetService;
import nobel.spring.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends BasicMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner owner) {
        if(owner == null)
            return null;

        if(owner.getPets() != null) {
            owner.getPets().forEach(pet -> {
                if(pet.getPetType() != null) {
                    if(pet.getPetType().getId() == null) {
                        petTypeService.save(pet.getPetType());
                    }
                } else {
                    throw new RuntimeException("Pet Type can't be null.");
                }

                if(pet.getId() == null)
                    petService.save(pet);

            });
        }
        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
