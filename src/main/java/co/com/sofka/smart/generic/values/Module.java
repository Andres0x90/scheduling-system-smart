package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Module implements ValueObject<String> {

    private final String value;

    public Module(String value) {
        this.value = Objects.requireNonNull(value, "El campo modulo es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}