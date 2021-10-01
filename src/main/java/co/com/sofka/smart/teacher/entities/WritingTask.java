package co.com.sofka.smart.teacher.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.values.WrittingTaskId;

public class WritingTask extends Entity<WrittingTaskId> {
    private Title title;
    private Description description;
    private Book book;
    private Module module;

    public WritingTask(WrittingTaskId writtingTaskId, Title title, Description description,
                       Book book, Module module) {
        super(writtingTaskId);
        this.title = title;
        this.description = description;
        this.book = book;
        this.module = module;
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

    public Module module() {
        return module;
    }
}
