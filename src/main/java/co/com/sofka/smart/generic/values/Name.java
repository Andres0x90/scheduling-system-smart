package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<Name.props> {
    private final String firstName, lastName;

    public Name(String firstName, String lastName)
    {
        this.firstName = Objects.requireNonNull(firstName, "El campo nombre es requerido");
        this.lastName = Objects.requireNonNull(lastName, "El campo apellido es requerido");
    }

    @Override
    public props value() {
        return new props() {
            @Override
            public String firstName() {
                return firstName;
            }

            @Override
            public String lastName() {
                return lastName;
            }
        };
    }

    public interface props {
        String firstName();
        String lastName();
    }
}
