package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;
import co.com.sofka.smart.student.values.StudentId;

public class GradeQuiz extends Command {
    private final StudentId studentId;
    private final QuizId quizId;
    private final Score score;

    public GradeQuiz(StudentId studentId, QuizId quizId, Score score) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.score = score;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public QuizId getQuizId() {
        return quizId;
    }

    public Score getScore() {
        return score;
    }
}
