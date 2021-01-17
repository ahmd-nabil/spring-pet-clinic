package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Pet;
import nobel.spring.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends BasicMapService<Pet, Long> implements PetService {
}
