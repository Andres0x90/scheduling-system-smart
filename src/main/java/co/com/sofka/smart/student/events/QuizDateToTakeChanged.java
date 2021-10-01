package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;

public class QuizDateToTakeChanged extends DomainEvent {
    private final QuizId quizId;
    private final DateTaken dateTaken;

    public QuizDateToTakeChanged(QuizId quizId, DateTaken dateTaken) {
        super("smart.student.quizdatetotakechanged");
        this.quizId = quizId;
        this.dateTaken = dateTaken;
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
