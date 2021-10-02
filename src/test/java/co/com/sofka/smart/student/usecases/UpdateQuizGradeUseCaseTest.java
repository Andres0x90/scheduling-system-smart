package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.GradeQuiz;
import co.com.sofka.smart.student.commands.UpdateQuizGrade;
import co.com.sofka.smart.student.events.QuizGradeUpdated;
import co.com.sofka.smart.student.events.QuizGraded;
import co.com.sofka.smart.student.storage.StudentStorage;
import co.com.sofka.smart.student.values.QuizId;
import co.com.sofka.smart.student.values.Score;
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

class UpdateQuizGradeUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    public void updateQuizGrade() throws ParseException {
        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(StudentStorage.getStudentData());
        var studentEvents = repository.getEventsBy("xxx-xxx");
        var student = Student.from(StudentId.of("xxx-xxx"), studentEvents);
        var command = new UpdateQuizGrade(student.identity(), QuizId.of("qqq-qqq"), new Score(90));
        var useCase = new UpdateQuizGradeUseCase();
        useCase.addRepository(repository);

        var quizGradeUpdated = (QuizGradeUpdated) UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents().get(0);

        assertEquals("qqq-qqq", quizGradeUpdated.getQuizId().value());
        assertEquals(90, quizGradeUpdated.getNewScore().value());
        assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }
}