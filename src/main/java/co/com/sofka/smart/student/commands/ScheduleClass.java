package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.PageNumber;
import co.com.sofka.smart.student.values.Status;

public class ScheduleClass extends Command {
    private final ClassId classId;
    private final Book book;
    private final Module module;
    private final PageNumber pageNumber;
    private final Status status;
    private final DateTaken dateTaken;

    public ScheduleClass(ClassId classId, Book book, Module module, PageNumber pageNumber,
                         Status status, DateTaken dateTaken) {
        this.classId = classId;
        this.book = book;
        this.module = module;
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

    public Module getModule() {
        return module;
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
