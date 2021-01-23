package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Visit;
import nobel.spring.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends BasicMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if(visit == null || visit.getPet() == null || visit.getPet().getId() == null ||
                visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        visit.getPet().getVisits().add(visit);
        return super.save(visit);
    }
}
