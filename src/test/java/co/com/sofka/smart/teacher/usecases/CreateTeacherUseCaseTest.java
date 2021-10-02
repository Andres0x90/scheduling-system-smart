package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.student.events.StudentCreated;
import co.com.sofka.smart.student.usecases.CreateStudentUseCase;
import co.com.sofka.smart.teacher.commands.CreateTeacher;
import co.com.sofka.smart.teacher.events.TeacherCreated;
import co.com.sofka.smart.teacher.values.Language;
import co.com.sofka.smart.teacher.values.TeacherId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateTeacherUseCaseTest {
    @Test
    public void createTeacher()
    {
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("Español"));
        languages.add(new Language("Ingles"));
        languages.add(new Language("Aleman"));
        var command = new CreateTeacher(
                new TeacherId("tttt-tttt"),
                new Name("Raul", "Alzate"),
                new Age("26"),
                new Address("Calle", "116A", "83-42", "Las brisas"),
                languages
        );
        var useCase = new CreateTeacherUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow()
                .getDomainEvents();
        var teacherCreated = (TeacherCreated) events.get(0);

        Assertions.assertEquals("tttt-tttt", teacherCreated.getTeacherId().value());
        Assertions.assertEquals("Raul", teacherCreated.getName().value().firstName());
        Assertions.assertEquals("Alzate", teacherCreated.getName().value().lastName());
        Assertions.assertEquals("26", teacherCreated.getAge().value());
    }
}