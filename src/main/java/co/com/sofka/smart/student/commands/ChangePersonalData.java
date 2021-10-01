package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;

public class ChangePersonalData extends Command {
    private  final Name name;
    private  final Age age;
    private  final Address address;

    public ChangePersonalData(Name name, Age age, Address address) {
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
