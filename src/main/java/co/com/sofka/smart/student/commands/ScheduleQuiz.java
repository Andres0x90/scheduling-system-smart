package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.values.TeacherId;

public class ScheduleQuiz extends Command {
    private final StudentId studentId;
    private final QuizId quizId;
    private final TeacherId teacherId;
    private final Book book;
    private final ModuleBook module;
    private final DateTaken dateTaken;

    public ScheduleQuiz(StudentId studentId, QuizId quizId, TeacherId teacherId, Book book, ModuleBook module,
                         DateTaken dateTaken) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.teacherId = teacherId;
        this.book = book;
        this.module = module;
        this.dateTaken = dateTaken;
    }
    public StudentId getStudentId() {
        return studentId;
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
        return module;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
