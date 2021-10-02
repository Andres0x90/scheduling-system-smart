package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeWorkBookAccountEmail;
import co.com.sofka.smart.student.events.ClassDateToTakeChanged;
import co.com.sofka.smart.student.events.EmailChanged;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.StudentId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class ChangeEmailTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public  void changeEmail() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new ChangeWorkBookAccountEmail(student.identity(),
                new Email("andres@sofka.com.co"));
        var useCase = new ChangeEmailUseCase();
        useCase.addRepository(repository);

        var emailChanged = (EmailChanged) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("andres@sofka.com.co", emailChanged.getNewEmail().value());
    }
}