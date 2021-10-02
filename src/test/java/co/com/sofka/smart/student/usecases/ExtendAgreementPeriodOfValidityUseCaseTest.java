package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeWorkBookAccountEmail;
import co.com.sofka.smart.student.commands.ExtendAgreementPeriodOfValidity;
import co.com.sofka.smart.student.events.AgreementPeriodOfValidityExtended;
import co.com.sofka.smart.student.events.EmailChanged;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.StudentId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class ExtendAgreementPeriodOfValidityUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void extendPeriodOfValidity() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new ExtendAgreementPeriodOfValidity(student.identity());
        var useCase = new ExtendAgreementPeriodOfValidityUseCase();
        useCase.addRepository(repository);

        var agreementPeriodOfValidityExtended = (AgreementPeriodOfValidityExtended)
                UseCaseHandler.getInstance().
                        syncExecutor(useCase, new RequestCommand<>(command))
                        .orElseThrow().getDomainEvents().get(0);

        assertNotNull(student.agreement().periodOfValidity());
    }
}