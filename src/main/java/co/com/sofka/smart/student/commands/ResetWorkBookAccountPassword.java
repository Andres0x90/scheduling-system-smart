package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Password;
import co.com.sofka.smart.student.values.StudentId;

public class ResetWorkBookAccountPassword extends Command {
    private final StudentId studentId;
    private final Password newPassword;

    public ResetWorkBookAccountPassword(StudentId studentId, Password newPassword) {
        this.studentId = studentId;
        this.newPassword = newPassword;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public Password getNewPassword() {
        return newPassword;
    }
}
