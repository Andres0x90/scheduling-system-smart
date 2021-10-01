package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.teacher.values.TeacherId;

public class ScheduleQuiz extends Command {
    private final QuizId quizId;
    private final TeacherId teacherId;
    private final Book book;
    private final Module module;
    private final DateTaken dateTaken;

    public ScheduleQuiz(QuizId quizId, TeacherId teacherId, Book book, Module module,
                         DateTaken dateTaken) {
        this.quizId = quizId;
        this.teacherId = teacherId;
        this.book = book;
        this.module = module;
        this.dateTaken = dateTaken;
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public TeacherId getTeacherId() {
        return teacherId;
    }

    public Book getBook() {
        return book;
    }

    public Module getModule() {
        return module;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
