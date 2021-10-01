package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ModuleBook implements ValueObject<String> {

    private final String value;

    public ModuleBook(String value) {
        this.value = Objects.requireNonNull(value, "El campo modulo es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}