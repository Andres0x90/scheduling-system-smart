package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.student.values.*;

public class CreateStudent extends Command {
    private final StudentId studentId;
    private final Name name;
    private final Age age;
    private final Address address;
    private final Username username;
    private final Password password;
    private final Email email;
    private final Signature signature;

    public CreateStudent(StudentId studentId, Name name, Age age, Address address, Username username,
                         Password password, Email email, Signature signature) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.signature = signature;
    }

    public StudentId getStudentId() {
        return studentId;
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

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }

    public Signature getSignature() {
        return signature;
    }
}
