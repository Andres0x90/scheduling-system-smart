package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeWorkBookAccountEmail;
import co.com.sofka.smart.student.commands.ScheduleQuiz;
import co.com.sofka.smart.student.events.EmailChanged;
import co.com.sofka.smart.student.events.QuizScheduled;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.values.TeacherId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class ScheduleQuizUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void scheduleQuiz() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        var command = new ScheduleQuiz(student.identity(),
                new QuizId("qzxxxx"), TeacherId.of("xxxx-xxxx"),
                new Book(new Title("B1 Intermediate Level"), "Cambridge"),
                new ModuleBook("Past Perfect"), new DateTaken(dateFormat.parse("2021-10-03 2:30"),
                dateFormat.parse("2021-10-03 4:00")));
        var useCase = new ScheduleQuizUseCase();
        useCase.addRepository(repository);

        var quizScheduled = (QuizScheduled) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("qzxxxx", quizScheduled.getQuizId().value());
        assertEquals("xxxx-xxxx", quizScheduled.getTeacherId().value());
        assertEquals("Past Perfect", quizScheduled.getModule().value());
    }
}