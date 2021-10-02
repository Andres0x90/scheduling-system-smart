package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.*;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangePersonalData;
import co.com.sofka.smart.student.commands.ScheduleClass;
import co.com.sofka.smart.student.events.ClassScheduled;
import co.com.sofka.smart.student.events.PersonalDataChanged;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ScheduleClassUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void scheduleClass() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        var command = new ScheduleClass(student.identity() ,new ClassId("fff-fff"),
                new Book(new Title("B1 Intermediate Level"), "Cambridge"),
                new ModuleBook("Phrases Verbs"), new PageNumber("16-17"),
                new Status("PROGRAMADA"),
                new DateTaken(dateFormat.parse("2021-10-03 2:30"),
                        dateFormat.parse("2021-10-03 4:00")));
        var useCase = new ScheduleClassUseCase();
        useCase.addRepository(repository);

        var classScheduled = (ClassScheduled) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("B1 Intermediate Level", classScheduled.getBook().value().title().value());
        assertEquals("Phrases Verbs", classScheduled.getModule().value());
        assertEquals("PROGRAMADA", classScheduled.getStatus().value());
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }

}