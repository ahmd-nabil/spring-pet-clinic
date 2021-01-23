package nobel.spring.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "vets")
public class Vet extends Person{

    public Vet() {}

    public Vet(String firstName, String lastName, Set<Specialty> specialties) {
        super(firstName, lastName);
        this.specialties = specialties;
    }

    @ManyToMany(fetch = FetchType.EAGER)        //default fetch type is LAZY for @ManyToMany
    @JoinTable(
            name = "vet_specialty",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private Set<Specialty> specialties = new HashSet<>();

    public void addSpecialty(Specialty specialty) {
        this.specialties.add(specialty);
    }
}
