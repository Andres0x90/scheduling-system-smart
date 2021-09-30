package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Title implements ValueObject<String> {
    private final String value;


    public Title(String value)
    {
        this.value = Objects.requireNonNull(value, "El campo titulo es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}
