package nobel.spring.petclinic.services;

import nobel.spring.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}