package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;

public class ChangeQuizDateToTake extends Command {
    private final QuizId quizId;
    private final DateTaken dateTaken;

    public ChangeQuizDateToTake(QuizId quizId, DateTaken dateTaken) {
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
