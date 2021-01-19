package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.PetType;
import nobel.spring.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends BasicMapService<PetType, Long> implements PetTypeService {
}
