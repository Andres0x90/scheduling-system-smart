package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;

public class GradeQuiz extends Command {
    private final QuizId quizId;
    private final Score score;

    public GradeQuiz(QuizId quizId, Score score) {
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
