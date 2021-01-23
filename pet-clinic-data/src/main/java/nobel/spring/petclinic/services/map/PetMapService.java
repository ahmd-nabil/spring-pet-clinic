package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Pet;
import nobel.spring.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends BasicMapService<Pet, Long> implements PetService {
}
