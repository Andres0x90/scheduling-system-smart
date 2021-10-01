package co.com.sofka.smart.teacher.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.teacher.values.Language;
import co.com.sofka.smart.teacher.values.TeacherId;

import java.util.List;

public class TeacherCreated extends DomainEvent {
    private final TeacherId teacherId;
    private final Name name;
    private final Age age;
    private final Address address;
    private final List<Language> languages;

    public TeacherCreated(TeacherId teacherId, Name name, Age age,
                          Address address, List<Language> languages) {
        super("smart.teacher.teachercreated");
        this.teacherId = teacherId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.languages = languages;
    }

    public TeacherId getTeacherId() {
        return teacherId;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
