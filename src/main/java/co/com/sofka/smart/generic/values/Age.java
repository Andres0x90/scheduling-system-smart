package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Age implements ValueObject<String> {

    private final String value;

    public Age(String value) {
        this.value = Objects.requireNonNull(value, "El campo edad es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}
