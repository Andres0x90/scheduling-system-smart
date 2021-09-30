package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Item implements ValueObject<Item.props> {
    private final String question;
    private final String answer;

    public Item(String question, String answer) {
        this.question = Objects.requireNonNull(question, "El campo pregunta es requerido");
        this.answer = Objects.requireNonNull(answer, "El campo respuesta es requerido");;
    }


    @Override
    public props value() {
        return new props() {
            @Override
            public String question() {
                return question;
            }

            @Override
            public String answer() {
                return answer;
            }
        };
    }

    public interface props {
        String question();
        String answer();
    }
}
