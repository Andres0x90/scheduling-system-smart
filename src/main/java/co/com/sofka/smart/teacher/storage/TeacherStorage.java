package co.com.sofka.smart.teacher.storage;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.*;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.commands.AddStudentReinforcementReportRequirement;
import co.com.sofka.smart.teacher.commands.CreateStudentReinforcementReport;
import co.com.sofka.smart.teacher.commands.CreateWritingTask;
import co.com.sofka.smart.teacher.commands.RemoveStudentReinforcementReportRequirement;
import co.com.sofka.smart.teacher.events.StudentReinforcementReportCreated;
import co.com.sofka.smart.teacher.events.StudentReinforcementReportRequirementAdded;
import co.com.sofka.smart.teacher.events.TeacherCreated;
import co.com.sofka.smart.teacher.events.WritingTaskCreated;
import co.com.sofka.smart.teacher.values.*;

import java.util.ArrayList;
import java.util.List;

public class TeacherStorage {
    public static List<DomainEvent> getTeacherData()
    {
        List<Language> languages = new ArrayList<>();
        languages.add(new Language("Español"));
        languages.add(new Language("Ingles"));
        languages.add(new Language("Aleman"));

        return List.of(
                new TeacherCreated(new TeacherId("tttt-tttt"),
                        new Name("Raul", "Alzate"),
                        new Age("26"),
                        new Address("Calle", "116A", "83-42", "Las brisas"),
                        languages
                ),
                new WritingTaskCreated(new WritingTaskId("wtxxxx"),
                        new Title("Writing for beginners"), new Description("Write down 5 sentences in past"),
                        new Book(new Title("A1 Beginners Level"), "Cambridge"),
                        new ModuleBook("Present and Past")),
                new StudentReinforcementReportCreated(new StudentReinforcementReportId("srrxxxx"),
                        StudentId.of("xxxx-xxxx"),
                        new Description("The student needs to improve past simple gramatic")),
                new StudentReinforcementReportRequirementAdded(StudentReinforcementReportId.of("srrxxxx"),
                        new Requirement("You have to do the last 10 book's exercises"))
        );
    }
}
