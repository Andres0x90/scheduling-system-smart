package co.com.sofka.smart.teacher.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class WritingTask extends Entity<WritingTaskId> {
    private Title title;
    private Description description;
    private Book book;
    private ModuleBook moduleBook;

    public WritingTask(WritingTaskId writingTaskId, Title title, Description description,
                       Book book, ModuleBook moduleBook) {
        super(writingTaskId);
        this.title = title;
        this.description = description;
        this.book = book;
        this.moduleBook = moduleBook;
    }

    public void updateTitle(Title title)
    {
        this.title = title;
    }
    public void updateDescription(Description description)
    {
        this.description = description;
    }

    public Title title() {
        return title;
    }

    public Description description() {
        return description;
    }

    public Book book() {
        return book;
    }

    public ModuleBook module() {
        return moduleBook;
    }
}
