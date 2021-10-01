package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class CreateWritingTask extends Command {
    private final WritingTaskId writingTaskId;
    private final Title title;
    private final Description description;
    private final Book book;
    private final ModuleBook module;

    public CreateWritingTask(WritingTaskId writingTaskId, Title title,
                              Description description, Book book, ModuleBook module) {
        this.writingTaskId = writingTaskId;
        this.title = title;
        this.description = description;
        this.book = book;
        this.module = module;
    }

    public WritingTaskId getWritingTaskId() {
        return writingTaskId;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public Book getBook() {
        return book;
    }

    public ModuleBook getModule() {
        return module;
    }
}
