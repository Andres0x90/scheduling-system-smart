package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PageNumber implements ValueObject<String> {

    private final String value;

    public PageNumber(String value) {
        this.value = Objects.requireNonNull(value, "El campo numero de pagina es requerido");
    }

    @Override
    public String value() {
        return value;
    }
}