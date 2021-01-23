package nobel.spring.petclinic.services.map;

import nobel.spring.petclinic.model.Vet;
import nobel.spring.petclinic.services.SpecialtyService;
import nobel.spring.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VetMapService extends BasicMapService<Vet, Long> implements VetService {
    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if(vet == null) return null;

        if(vet.getSpecialties() != null) {
            vet.getSpecialties().forEach(specialty -> {
                if(specialty != null) {
                    if(specialty.getId() == null) {
                        specialtyService.save(specialty);
                    }
                }
            });
        }
        return super.save(vet);
    }
}
