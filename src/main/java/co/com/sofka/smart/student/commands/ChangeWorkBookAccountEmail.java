package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.StudentId;

public class ChangeWorkBookAccountEmail extends Command {
    private final StudentId studentId;
    private final Email newEmail;

    public ChangeWorkBookAccountEmail(StudentId studentId, Email newEmail) {
        this.studentId = studentId;
        this.newEmail = newEmail;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public Email getNewEmail() {
        return newEmail;
    }
}
