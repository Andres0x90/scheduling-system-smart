package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.teacher.values.Language;
import co.com.sofka.smart.teacher.values.TeacherId;

import java.util.List;

public class CreateTeacher extends Command {
    private final TeacherId teacherId;
    private final Name name;
    private final Age age;
    private final Address address;
    private final List<Language> languages;

    public CreateTeacher(TeacherId teacherId, Name name, Age age,
                          Address address, List<Language> languages) {
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
