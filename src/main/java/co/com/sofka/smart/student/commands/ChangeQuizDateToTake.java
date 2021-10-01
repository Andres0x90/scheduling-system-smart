package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.StudentId;

public class ChangeQuizDateToTake extends Command {
    private final StudentId studentId;
    private final QuizId quizId;
    private final DateTaken dateTaken;

    public ChangeQuizDateToTake(StudentId studentId, QuizId quizId, DateTaken dateTaken) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.dateTaken = dateTaken;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
