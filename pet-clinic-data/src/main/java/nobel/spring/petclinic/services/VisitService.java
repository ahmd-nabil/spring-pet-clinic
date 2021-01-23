package nobel.spring.petclinic.services;

import nobel.spring.petclinic.model.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService extends BasicCrudService<Visit, Long>{
}
