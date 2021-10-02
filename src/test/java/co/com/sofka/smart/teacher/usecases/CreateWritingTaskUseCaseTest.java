package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeWorkBookAccountEmail;
import co.com.sofka.smart.student.events.EmailChanged;
import co.com.sofka.smart.student.usecases.ChangeEmailUseCase;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.CreateWritingTask;
import co.com.sofka.smart.teacher.events.WritingTaskCreated;
import co.com.sofka.smart.teacher.storage.TeacherStorage;
import co.com.sofka.smart.teacher.values.TeacherId;
import co.com.sofka.smart.teacher.values.WritingTaskId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class CreateWritingTaskUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void createWritingTask()
    {
        Mockito.when(repository.getEventsBy("tttt-tttt")).thenReturn(TeacherStorage.getTeacherData());
        var teacherEvents = repository.getEventsBy("tttt-tttt");
        var teacher = Teacher.from(TeacherId.of("tttt-tttt"), teacherEvents);
        var command = new CreateWritingTask(teacher.identity(), new WritingTaskId("wtxxxx"),
                new Title("Writing for beginners"), new Description("Write down 5 sentences in past"),
                new Book(new Title("A1 Beginners Level"), "Cambridge"),
                new ModuleBook("Present and Past"));
        var useCase = new CreateWritingTaskUseCase();
        useCase.addRepository(repository);

        var writingTaskCreated = (WritingTaskCreated) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("wtxxxx", writingTaskCreated.getWritingTaskId().value());
        assertEquals("Writing for beginners", writingTaskCreated.getTitle().value());
        assertEquals("Write down 5 sentences in past", writingTaskCreated.getDescription().value());
    }
}