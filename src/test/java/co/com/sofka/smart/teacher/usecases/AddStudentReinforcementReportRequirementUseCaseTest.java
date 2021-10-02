package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.AddStudentReinforcementReportRequirement;
import co.com.sofka.smart.teacher.commands.ChangeStudentReinforcementReportDescription;
import co.com.sofka.smart.teacher.events.StudentReinforcementReportDescriptionChanged;
import co.com.sofka.smart.teacher.events.StudentReinforcementReportRequirementAdded;
import co.com.sofka.smart.teacher.storage.TeacherStorage;
import co.com.sofka.smart.teacher.values.Requirement;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;
import co.com.sofka.smart.teacher.values.TeacherId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddStudentReinforcementReportRequirementUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void addStudentReinforcementReportRequirement()
    {
        Mockito.when(repository.getEventsBy("tttt-tttt")).thenReturn(TeacherStorage.getTeacherData());
        var teacherEvents = repository.getEventsBy("tttt-tttt");
        var teacher = Teacher.from(TeacherId.of("tttt-tttt"), teacherEvents);
        var command = new AddStudentReinforcementReportRequirement(teacher.identity(),
                StudentReinforcementReportId.of("srrxxxx"),
                new Requirement("You have to do the last 10 book's exercises"));
        var useCase = new AddStudentReinforcementReportRequirementUseCase();
        useCase.addRepository(repository);

        var studentReinforcementReportRequirementAdded = (StudentReinforcementReportRequirementAdded)
                UseCaseHandler.getInstance().
                        syncExecutor(useCase, new RequestCommand<>(command))
                        .orElseThrow().getDomainEvents().get(0);

        assertEquals("srrxxxx", studentReinforcementReportRequirementAdded.getStudentReinforcementReportId()
                .value());
        assertEquals("You have to do the last 10 book's exercises",
                studentReinforcementReportRequirementAdded.getRequirement()
                .value());
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }
}