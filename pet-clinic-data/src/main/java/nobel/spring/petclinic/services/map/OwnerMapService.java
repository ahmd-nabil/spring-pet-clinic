package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Owner;
import nobel.spring.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends BasicMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
