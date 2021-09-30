package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String value;

    public Email(String value) {
        this.value = Objects.requireNonNull(value, "El campo email es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}