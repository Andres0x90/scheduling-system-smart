package co.com.sofka.smart.teacher.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Requirement implements ValueObject<String> {

    private final String value;

    public Requirement(String value)
    {
        this.value = Objects.requireNonNull(value, "El campo requerimiento es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}
