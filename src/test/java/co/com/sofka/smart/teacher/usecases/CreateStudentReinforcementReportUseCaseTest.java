package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.ChangeWritingTaskDescription;
import co.com.sofka.smart.teacher.commands.CreateStudentReinforcementReport;
import co.com.sofka.smart.teacher.events.StudentReinforcementReportCreated;
import co.com.sofka.smart.teacher.events.WritingTaskDescriptionChanged;
import co.com.sofka.smart.teacher.storage.TeacherStorage;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;
import co.com.sofka.smart.teacher.values.TeacherId;
import co.com.sofka.smart.teacher.values.WritingTaskId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class CreateStudentReinforcementReportUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void createStudentReinforcementReport()
    {
        Mockito.when(repository.getEventsBy("tttt-tttt")).thenReturn(TeacherStorage.getTeacherData());
        var teacherEvents = repository.getEventsBy("tttt-tttt");
        var teacher = Teacher.from(TeacherId.of("tttt-tttt"), teacherEvents);
        var command = new CreateStudentReinforcementReport(teacher.identity(),
                new StudentReinforcementReportId("srrxxxx"), StudentId.of("xxxx-xxxx"),
                new Description("The student needs to improve past simple gramatic"));
        var useCase = new CreateStudentReinforcementReportUseCase();
        useCase.addRepository(repository);

        var studentReinforcementReportCreated = (StudentReinforcementReportCreated) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("srrxxxx", studentReinforcementReportCreated.getStudentReinforcementReportId()
                .value());
        assertEquals("xxxx-xxxx", studentReinforcementReportCreated.getStudentId()
                .value());
        assertEquals("The student needs to improve past simple gramatic",
                studentReinforcementReportCreated.getDescription().value());
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }
}