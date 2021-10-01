package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.PageNumber;
import co.com.sofka.smart.student.values.Status;

public class ClassScheduled extends DomainEvent {
    private final ClassId classId;
    private final Book book;
    private final ModuleBook moduleBook;
    private final PageNumber pageNumber;
    private final Status status;
    private final DateTaken dateTaken;

    public ClassScheduled(ClassId classId, Book book, ModuleBook moduleBook, PageNumber pageNumber,
                          Status status, DateTaken dateTaken) {
        super("smart.student.classscheduled");
        this.classId = classId;
        this.book = book;
        this.moduleBook = moduleBook;
        this.pageNumber = pageNumber;
        this.status = status;
        this.dateTaken = dateTaken;
    }

    public ClassId getClassId() {
        return classId;
    }

    public Book getBook() {
        return book;
    }

    public ModuleBook getModule() {
        return moduleBook;
    }

    public PageNumber getPageNumber() {
        return pageNumber;
    }

    public Status getStatus() {
        return status;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
