package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangePersonalData;
import co.com.sofka.smart.student.events.PersonalDataChanged;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.StudentId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChangePersonalDataUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    public void changePersonalData()
    {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new ChangePersonalData(
                student.identity(), new Name("Juan", "Perez"), new Age("26"),
                new Address("Avenida", "45", "37-32", "Gratamira")
        );
        var useCase = new ChangePersonalDataUseCase();
        useCase.addRepository(repository);

         var studentPersonalDataChanged = (PersonalDataChanged)UseCaseHandler.getInstance().
                 syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        Assertions.assertEquals("Juan", studentPersonalDataChanged.getName()
                .value().firstName());
        Assertions.assertEquals("26", studentPersonalDataChanged.getAge().value());
        Assertions.assertEquals("Gratamira", studentPersonalDataChanged.getAddress().value()
                .neighborhood());
    }
}