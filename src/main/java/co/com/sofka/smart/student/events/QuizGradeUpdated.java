package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;

public class QuizGradeUpdated extends DomainEvent {
    private final QuizId quizId;
    private final Score newScore;

    public QuizGradeUpdated(QuizId quizId, Score newScore) {
        super("smart.student.quizgradeupdated");
        this.quizId = quizId;
        this.newScore = newScore;
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public Score getNewScore() {
        return newScore;
    }
}
