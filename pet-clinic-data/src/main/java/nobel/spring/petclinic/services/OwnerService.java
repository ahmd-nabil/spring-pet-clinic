package nobel.spring.petclinic.services;

import nobel.spring.petclinic.model.Owner;

public interface OwnerService extends BasicCrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}