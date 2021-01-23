package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.PetType;
import nobel.spring.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends BasicMapService<PetType, Long> implements PetTypeService {
}
