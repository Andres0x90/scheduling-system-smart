package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Address implements ValueObject<Address.props> {
    private final String type, street, number, neighborhood;

    public Address(String type, String street, String numero, String barrio) {
        this.type = Objects.requireNonNull(type, "El campo tipo no debe estar vacio");
        this.street = Objects.requireNonNull(street, "El campo calle no debe estar vacio");
        this.number = Objects.requireNonNull(numero, "El campo numero no debe estar vacio");
        this.neighborhood = Objects.requireNonNull(barrio, "El campo barrio no debe estar vacio");
    }

    @Override
    public props value() {
        return new props() {
            @Override
            public String type() {
                return type;
            }

            @Override
            public String street() {
                return street;
            }

            @Override
            public String number() {
                return number;
            }

            @Override
            public String neighborhood() {
                return neighborhood;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(type, address.type) && Objects.equals(street, address.street) && Objects.equals(number, address.number) && Objects.equals(neighborhood, address.neighborhood);
    }

    public interface props {
        String type();
        String street();
        String number();
        String neighborhood();
    }
}
