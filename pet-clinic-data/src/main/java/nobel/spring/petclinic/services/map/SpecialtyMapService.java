package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Specialty;
import nobel.spring.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends BasicMapService<Specialty, Long> implements SpecialtyService {

}
