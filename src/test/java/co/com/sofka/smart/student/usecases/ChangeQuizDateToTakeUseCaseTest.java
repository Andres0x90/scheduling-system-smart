package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeClassDateToTake;
import co.com.sofka.smart.student.commands.ChangeQuizDateToTake;
import co.com.sofka.smart.student.events.ClassDateToTakeChanged;
import co.com.sofka.smart.student.events.QuizDateToTakeChanged;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.StudentId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class ChangeQuizDateToTakeUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void changeQuizDateToTake() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        var command = new ChangeQuizDateToTake(student.identity(), QuizId.of("qqq-qqq"),
                new DateTaken(dateFormat.parse("2021-09-21 1:30"),
                        dateFormat.parse("2021-09-21 4:00")));
        var useCase = new ChangeQuizDateToTakeUseCase();
        useCase.addRepository(repository);

        var quizDateToTakeChanged = (QuizDateToTakeChanged) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("qqq-qqq", quizDateToTakeChanged.getQuizId().value());
        assertEquals(dateFormat.parse("2021-09-21 1:30"),
                quizDateToTakeChanged.getDateTaken().value().startDate());
        assertEquals(dateFormat.parse("2021-09-21 4:00"),
                quizDateToTakeChanged.getDateTaken().value().endDate());
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }
}