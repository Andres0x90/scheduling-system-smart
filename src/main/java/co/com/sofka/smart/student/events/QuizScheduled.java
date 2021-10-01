package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.teacher.values.TeacherId;

public class QuizScheduled extends DomainEvent {
    private final QuizId quizId;
    private final TeacherId teacherId;
    private final Book book;
    private final ModuleBook moduleBook;
    private final DateTaken dateTaken;

    public QuizScheduled(QuizId quizId, TeacherId teacherId, Book book, ModuleBook moduleBook,
                         DateTaken dateTaken) {
        super("smart.student.quizscheduled");
        this.quizId = quizId;
        this.teacherId = teacherId;
        this.book = book;
        this.moduleBook = moduleBook;
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

    public ModuleBook getModule() {
        return moduleBook;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }

}
