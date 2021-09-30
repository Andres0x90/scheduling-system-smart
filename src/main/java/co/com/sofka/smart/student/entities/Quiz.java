package co.com.sofka.smart.student.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.student.values.*;
import co.com.sofka.smart.teacher.values.TeacherId;

import java.util.List;

public class Quiz extends Entity<QuizId> {
    private TeacherId teacherId;
    private Book book;
    private Module module;
    private List<Item>items;
    private DateTaken dateTaken;
    private Score score;
    private Status status;

    public Quiz(QuizId entityId, TeacherId teacherId, Book book, Module module,
                 DateTaken dateTaken, Score score, Status status) {
        super(entityId);
        this.teacherId = teacherId;
        this.book = book;
        this.module = module;
        this.dateTaken = dateTaken;
        this.score = score;
        this.status = status;
    }

    public void addAnswer(String question,String answer)
    {
        items.add(new Item(question,answer));
    }
    public void assignScore(Integer grade)
    {
        this.score = new Score(grade);
        this.status = new Status("CALIFICADO");
    }
    public void updateScore(Integer grade)
    {
        this.score = new Score(grade);
        this.status = new Status("CALIFICACION CAMBIADA");
    }
    public TeacherId teacherId() {
        return teacherId;
    }

    public Book book() {
        return book;
    }

    public Module module() {
        return module;
    }

    public List<Item> items() {
        return items;
    }

    public DateTaken dateTaken() {
        return dateTaken;
    }

    public Score score() {
        return score;
    }

    public Status status() {
        return status;
    }
}
