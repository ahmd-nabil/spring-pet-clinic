package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Vet;
import nobel.spring.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends BasicMapService<Vet, Long> implements VetService {

}
