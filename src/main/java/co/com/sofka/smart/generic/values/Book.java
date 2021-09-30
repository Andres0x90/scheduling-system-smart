package co.com.sofka.smart.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Book implements ValueObject<Book.props> {
    private final Title title;
    private final String author;

    public Book(Title title, String author) {
        this.title =  Objects.requireNonNull(title, "El campo titulo es requerido");;
        this.author = Objects.requireNonNull(author, "El campo autor es requerido");
    }

    @Override
    public props value() {
        return new props() {
            @Override
            public Title title() {
                return title;
            }

            @Override
            public String author() {
                return author;
            }
        };
    }

    public interface props {
        Title title();
        String author();
    }
}
