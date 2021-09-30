package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Username implements ValueObject<String> {

    private final String value;

    public Username(String value) {
        this.value = Objects.requireNonNull(value, "El campo usuario es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}