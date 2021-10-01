package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Item;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.StudentId;

public class AnswerQuizQuestion extends Command {
    private final StudentId studentId;
    private final QuizId quizId;
    private final Item item;

    public AnswerQuizQuestion(StudentId studentId, QuizId quizId, Item item) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.item = item;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public QuizId getQuizId() {
        return quizId;
    }

    public Item getItem() {
        return item;
    }
}
