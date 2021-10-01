package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.student.commands.CreateStudent;
import co.com.sofka.smart.student.events.StudentCreated;
import co.com.sofka.smart.student.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateStudentUseCaseTest {
    @Test
    public void createStudent()
    {
        var command = new CreateStudent(
                new StudentId("xxx-xxx"),
                new Name("Andres Mauricio", "Cano Causil"),
                new Age("19"),
                new Address("Calle", "116A", "83-42", "Las brisas"),
                new Username("Andres0x90"),
                new Password("1234"),
                new Email("andrescaza246@hotmail.com"),
                new Signature("Andres M Cano")
        );
        var useCase = new CreateStudentUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow()
                .getDomainEvents();
        var studentCreated = (StudentCreated) events.get(0);

        Assertions.assertEquals("xxx-xxx", studentCreated.getStudentId().value());
        Assertions.assertEquals("Andres Mauricio", studentCreated.getName().value().firstName());
        Assertions.assertEquals("Cano Causil", studentCreated.getName().value().lastName());
        Assertions.assertEquals("Andres0x90", studentCreated.getUsername().value());
        Assertions.assertEquals("andrescaza246@hotmail.com",
                studentCreated.getEmail().value());
    }

}