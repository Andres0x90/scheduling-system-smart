package co.com.sofka.smart.teacher.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Language implements ValueObject<String> {
    private final String value;

    public Language(String value)
    {
        this.value = Objects.requireNonNull(value, "El campo lenguaje es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}
