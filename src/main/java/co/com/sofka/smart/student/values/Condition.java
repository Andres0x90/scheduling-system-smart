package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

public class Condition implements ValueObject<String> {
    private final String value;

    public Condition(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
