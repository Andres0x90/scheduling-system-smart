package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeClassDateToTake;
import co.com.sofka.smart.student.commands.ResetWorkBookAccountPassword;
import co.com.sofka.smart.student.events.ClassDateToTakeChanged;
import co.com.sofka.smart.student.events.PasswordReseted;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.Password;
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

class ResetPasswordUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void resetPassword() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new ResetWorkBookAccountPassword(student.identity(), new Password("321"));
        var useCase = new ResetPasswordUseCase();
        useCase.addRepository(repository);

        var passwordReseted = (PasswordReseted) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("321", passwordReseted.getNewPassword().value());
    }

}