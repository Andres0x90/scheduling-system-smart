package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.CancelClass;
import co.com.sofka.smart.student.commands.ScheduleClass;
import co.com.sofka.smart.student.events.ClassCanceled;
import co.com.sofka.smart.student.events.ClassScheduled;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class CancelClassUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @Test
    public void cancelClass() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new CancelClass(student.identity(), ClassId.of("ggg-ggg"));
        var useCase = new CancelClassUseCase();
        useCase.addRepository(repository);

        var classCanceled = (ClassCanceled) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("ggg-ggg", classCanceled.getClassId().value());
        assertDoesNotThrow(()-> new IllegalArgumentException());
    }

}