package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.generic.values.ModuleBook;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.ChangeWritingTaskTitle;
import co.com.sofka.smart.teacher.commands.CreateWritingTask;
import co.com.sofka.smart.teacher.events.WritingTaskCreated;
import co.com.sofka.smart.teacher.events.WritingTaskTitleChanged;
import co.com.sofka.smart.teacher.storage.TeacherStorage;
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

class ChangeWritingTaskTitleUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void changeWritingTaskTitle()
    {
        Mockito.when(repository.getEventsBy("tttt-tttt")).thenReturn(TeacherStorage.getTeacherData());
        var teacherEvents = repository.getEventsBy("tttt-tttt");
        var teacher = Teacher.from(TeacherId.of("tttt-tttt"), teacherEvents);
        var command = new ChangeWritingTaskTitle(teacher.identity(),
                 WritingTaskId.of("wtxxxx"), new Title("Other title"));
        var useCase = new ChangeWritingTaskTitleUseCase();
        useCase.addRepository(repository);

        var writingTaskTitleChanged = (WritingTaskTitleChanged) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("Other title",writingTaskTitleChanged.getTitle().value());
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }
}