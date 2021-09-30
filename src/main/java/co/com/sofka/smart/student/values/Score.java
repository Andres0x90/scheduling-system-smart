package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Score implements ValueObject<Integer> {

    private final Integer value;

    public Score(Integer value) {
        this.value = Objects.requireNonNull(value, "El campo puntaje es requerido");
    }

    @Override
    public Integer value() {
        return value;
    }
}