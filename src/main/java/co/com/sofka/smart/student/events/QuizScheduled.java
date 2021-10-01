package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Status;
import co.com.sofka.smart.teacher.values.TeacherId;

public class QuizScheduled extends DomainEvent {
    private final QuizId quizId;
    private final TeacherId teacherId;
    private final Book book;
    private final Module module;
    private final DateTaken dateTaken;

    public QuizScheduled(QuizId quizId, TeacherId teacherId, Book book, Module module,
                         DateTaken dateTaken) {
        super("smart.student.quizscheduled");
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
