package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.student.values.*;

public class ScheduleClass extends Command {
    private final StudentId studentId;
    private final ClassId classId;
    private final Book book;
    private final ModuleBook module;
    private final PageNumber pageNumber;
    private final Status status;
    private final DateTaken dateTaken;

    public ScheduleClass(StudentId studentId, ClassId classId, Book book, ModuleBook module, PageNumber pageNumber,
                         Status status, DateTaken dateTaken) {
        this.studentId = studentId;
        this.classId = classId;
        this.book = book;
        this.module = module;
        this.pageNumber = pageNumber;
        this.status = status;
        this.dateTaken = dateTaken;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public ClassId getClassId() {
        return classId;
    }

    public Book getBook() {
        return book;
    }

    public ModuleBook getModule() {
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
