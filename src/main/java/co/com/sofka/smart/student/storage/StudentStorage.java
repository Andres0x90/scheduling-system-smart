package co.com.sofka.smart.student.storage;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.*;
import co.com.sofka.smart.student.events.ClassScheduled;
import co.com.sofka.smart.student.events.QuizScheduled;
import co.com.sofka.smart.student.events.StudentCreated;
import co.com.sofka.smart.student.values.*;
import co.com.sofka.smart.teacher.values.TeacherId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentStorage {
    public static List<DomainEvent> getStudentData() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return List.of(
                new StudentCreated(
                        new StudentId("xxx-xxx"),
                        new Name("Andres Mauricio", "Cano Causil"),
                        new Age("19"),
                        new Address("Calle", "116A", "83-42", "Las brisas"),
                        new Username("Andres0x90"),
                        new Password("1234"),
                        new Email("andrescaza246@hotmail.com"),
                        new Signature("Andres M Cano")
                ),
                new ClassScheduled(new ClassId("ggg-ggg"), new Book(new Title("A2 Beggining"),
                        "Cambridge"), new ModuleBook("Conditionals"), new PageNumber("27"),
                        new Status("PROGRAMADA"),
                        new DateTaken(dateFormat.parse("2021-09-08 1:00"),
                                dateFormat.parse("2021-09-08 2:00"))),
                new QuizScheduled(new QuizId("qqq-qqq"), TeacherId.of("tttt-tttt"),
                        new Book(new Title("A2 Beggining"),
                        "Cambridge"), new ModuleBook("Present Continous"),
                        new DateTaken(dateFormat.parse("2021-09-08 1:00"),
                                dateFormat.parse("2021-09-08 2:00")))
            );
    }
}
