package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.StudentId;

public class ExtendAgreementPeriodOfValidity extends Command {
    private final StudentId studentId;
    public ExtendAgreementPeriodOfValidity(StudentId studentId) {
        this.studentId = studentId;
    }
    public StudentId getStudentId() {
        return studentId;
    }
}
