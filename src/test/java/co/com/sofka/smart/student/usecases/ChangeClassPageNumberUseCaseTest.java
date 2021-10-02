package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.CancelClass;
import co.com.sofka.smart.student.commands.ChangeClassPageNumber;
import co.com.sofka.smart.student.events.ClassCanceled;
import co.com.sofka.smart.student.events.ClassPageNumberChanged;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.PageNumber;
import co.com.sofka.smart.student.values.StudentId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class ChangeClassPageNumberUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @Test
    public void changeClassPageNumber() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new ChangeClassPageNumber(student.identity(), ClassId.of("ggg-ggg"),
                new PageNumber("62"));
        var useCase = new ChangeClassPageNumberUseCase();
        useCase.addRepository(repository);

        var classPageNumberChanged = (ClassPageNumberChanged) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("62", classPageNumberChanged.getNewPageNumber().value());
        assertDoesNotThrow(()-> new IllegalArgumentException());
    }
}