package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;
import co.com.sofka.smart.student.values.StudentId;

public class UpdateQuizGrade extends Command {
    private final StudentId studentId;
    private final QuizId quizId;
    private final Score newScore;

    public UpdateQuizGrade(StudentId studentId, QuizId quizId, Score newScore) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.newScore = newScore;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public QuizId getQuizId() {
        return quizId;
    }

    public Score getNewScore() {
        return newScore;
    }
}
