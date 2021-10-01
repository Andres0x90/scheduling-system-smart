package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.*;

public class CreateWorkBookAccount extends Command {
    private final StudentId studentId;
    private final WorkBookAccountId workBookAccountId;
    private final Username username;
    private final Password password;
    private final Email email;

    public CreateWorkBookAccount(StudentId studentId, WorkBookAccountId workBookAccountId, Username username,
                                  Password password, Email email) {
        this.studentId = studentId;
        this.workBookAccountId = workBookAccountId;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public WorkBookAccountId getWorkBookAccountId() {
        return workBookAccountId;
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
}
