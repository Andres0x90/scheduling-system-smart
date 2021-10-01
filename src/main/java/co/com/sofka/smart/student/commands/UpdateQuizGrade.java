package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;

public class UpdateQuizGrade extends Command {
    private final QuizId quizId;
    private final Score newScore;

    public UpdateQuizGrade(QuizId quizId, Score newScore) {
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
