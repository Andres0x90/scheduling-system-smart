package co.com.sofka.smart.student.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.PageNumber;
import co.com.sofka.smart.student.values.Status;

public class Class extends Entity<ClassId> {
    private Book book;
    private Module module;
    private PageNumber pageNumber;
    private Status status;
    private DateTaken date;

    public Class(ClassId classId, Book book, Module module, PageNumber pageNumber, Status status, DateTaken date) {
        super(classId);
        this.book = book;
        this.module = module;
        this.pageNumber = pageNumber;
        this.status = status;
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

    public Module module() {
        return module;
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
