package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Status implements ValueObject<String> {

    private final String value;

    public Status(String value) {
        this.value = Objects.requireNonNull(value, "El campo estado es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}