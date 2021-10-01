package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;

public class QuizGraded extends DomainEvent {
    private final QuizId quizId;
    private final Score score;

    public QuizGraded(QuizId quizId, Score score) {
        super("smart.student.quizgraded");
        this.quizId = quizId;
        this.score = score;
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public Score getScore() {
        return score;
    }
}
