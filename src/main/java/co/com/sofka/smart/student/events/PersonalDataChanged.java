package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;

public class PersonalDataChanged extends DomainEvent {
    private  final Name name;
    private  final Age age;
    private  final Address address;

    public PersonalDataChanged(Name name, Age age, Address address) {
        super("smart.student.personalDataChanged");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
