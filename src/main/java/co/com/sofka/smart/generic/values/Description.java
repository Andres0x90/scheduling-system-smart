package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {

    private final String value;

    public Description(String value) {
        this.value = Objects.requireNonNull(value, "El campo descripcion es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}