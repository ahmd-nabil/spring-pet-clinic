package nobel.spring.petclinic.services;

import nobel.spring.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends BasicCrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}