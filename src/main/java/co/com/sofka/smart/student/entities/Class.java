package co.com.sofka.smart.student.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.PageNumber;
import co.com.sofka.smart.student.values.Status;

public class Class extends Entity<ClassId> {
    private Book book;
    private ModuleBook moduleBook;
    private PageNumber pageNumber;
    private Status status;
    private DateTaken date;

    public Class(ClassId classId, Book book, ModuleBook moduleBook, PageNumber pageNumber, DateTaken date) {
        super(classId);
        this.book = book;
        this.moduleBook = moduleBook;
        this.pageNumber = pageNumber;
        this.status = new Status("PROGRAMADA");
        this.date = date;
    }

    public void updatePageNumber(PageNumber pageNumber)
    {
        this.pageNumber = pageNumber;
    }
    public void updateStatus(Status status)
    {
        this.status = status;
    }
    public void updateDate(DateTaken date)
    {
        this.date = date;
    }

    public Book book() {
        return book;
    }

    public ModuleBook module() {
        return moduleBook;
    }

    public PageNumber pageNumber() {
        return pageNumber;
    }

    public Status status() {
        return status;
    }

    public DateTaken date() {
        return date;
    }
}
