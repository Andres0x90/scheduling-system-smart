package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeClassDateToTake;
import co.com.sofka.smart.student.commands.CreateWorkBookAccount;
import co.com.sofka.smart.student.events.ClassDateToTakeChanged;
import co.com.sofka.smart.student.events.WorkBookAccountCreated;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class CreateWorkBookAccountUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void createWorkBookAcoount() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new CreateWorkBookAccount(student.identity(),new WorkBookAccountId("wkaxxxx"),
                new Username("Andres0x90"), new Password("1234"),
                new Email("andrescaza246@hotmail.com"));
        var useCase = new CreateWorkBookAccountUseCase();
        useCase.addRepository(repository);

        var  workBookAccountCreated = (WorkBookAccountCreated) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("wkaxxxx", workBookAccountCreated.getWorkBookAccountId().value());
        Assertions.assertEquals("Andres0x90", workBookAccountCreated.getUsername().value());
        Assertions.assertEquals("andrescaza246@hotmail.com",
                workBookAccountCreated.getEmail().value());
    }

}