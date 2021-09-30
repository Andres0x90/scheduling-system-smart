package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.Identity;

public class QuizId extends Identity {
    public QuizId(String id)
    {
        super(id);
    }
    public QuizId(){super();}
    public static QuizId of(String id)
    {
        return new QuizId(id);
    }
}
