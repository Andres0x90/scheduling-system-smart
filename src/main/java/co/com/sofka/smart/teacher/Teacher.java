package co.com.sofka.smart.teacher;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.*;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.entities.StudentReinforcementReport;
import co.com.sofka.smart.teacher.entities.WritingTask;
import co.com.sofka.smart.teacher.events.*;
import co.com.sofka.smart.teacher.values.*;

import java.util.List;

public class Teacher extends AggregateEvent<TeacherId> {
    protected Name name;
    protected Age age;
    protected Address address;
    protected List<Language>languages;
    protected List<WritingTask>writingTasks;
    protected List<StudentReinforcementReport>studentReinforcementReports;

    public Teacher(TeacherId teacherId, Name name, Age age, Address address, List<Language> languages)
    {
        super(teacherId);
        appendChange(new TeacherCreated(teacherId, name, age, address, languages)).apply();
    }

    private Teacher(TeacherId teacherId) {
        super(teacherId);
        subscribe(new TeacherChange(this));
    }

    public static Teacher from(TeacherId teacherId, List<DomainEvent> events) {
        var teacher = new Teacher(teacherId);
        events.forEach(teacher::applyEvent);
        return teacher;
    }
    public void createWritingTask(WritingTaskId writingTaskId, Title title, Description description,
                                  Book book, ModuleBook module)
    {
        appendChange(new WritingTaskCreated(writingTaskId, title, description,book, module));
    }
    public void changeWritingTaskTitle(WritingTaskId writingTaskId, Title title)
    {
        appendChange(new WritingTaskTitleChanged(writingTaskId, title)).apply();
    }
    public void changeWritingTaskDescription(WritingTaskId writingTaskId, Description description)
    {
        appendChange(new WritingTaskDescriptionChanged(writingTaskId, description)).apply();
    }
    public void createStudentReinforcementReport(StudentReinforcementReportId studentReinforcementReportId,
                                                 StudentId studentId, Description description)
    {
        appendChange(new StudentReinforcementReportCreated(studentReinforcementReportId,
                studentId, description));
    }
    public void changeStudentReinforcementReportDescription(StudentReinforcementReportId studentReinforcementReportId,
                                                            Description description)
    {
        appendChange(new StudentReinforcementReportDescriptionChanged(
                studentReinforcementReportId,description
        )).apply();
    }
    public void addStudentReinforcementReportRequirement(StudentReinforcementReportId studentReinforcementReportId,
                                                         Requirement requirement)
    {
        appendChange(new StudentReinforcementReportRequirementAdded(studentReinforcementReportId,
                requirement));
    }
    public void removeStudentReinforcementReportRequirement(StudentReinforcementReportId studentReinforcementReportId,
                                                         Requirement requirement)
    {
        appendChange(new StudentReinforcementReportRequirementRemoved(studentReinforcementReportId,
                requirement));
    }
    public Name name() {
        return name;
    }

    public Age age() {
        return age;
    }

    public Address address() {
        return address;
    }

    public List<Language> languages() {
        return languages;
    }

    public List<WritingTask> writingTasks() {
        return writingTasks;
    }

    public List<StudentReinforcementReport> studentReinforcementReports() {
        return studentReinforcementReports;
    }
}
