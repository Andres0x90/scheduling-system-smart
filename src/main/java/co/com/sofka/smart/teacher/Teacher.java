package co.com.sofka.smart.teacher;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.entities.StudentReinforcementReport;
import co.com.sofka.smart.teacher.entities.WritingTask;
import co.com.sofka.smart.teacher.events.TeacherCreated;
import co.com.sofka.smart.teacher.values.Language;
import co.com.sofka.smart.teacher.values.TeacherId;

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
    public void changeWrittingTaskTitle(Title title)
    {

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
