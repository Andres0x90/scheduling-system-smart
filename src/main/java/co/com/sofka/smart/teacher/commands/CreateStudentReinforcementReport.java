package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

public class CreateStudentReinforcementReport extends Command {
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final StudentId studentId;
    private final Description description;

    public CreateStudentReinforcementReport(StudentReinforcementReportId studentReinforcementReportId,
                                             StudentId studentId, Description description) {
        this.studentReinforcementReportId = studentReinforcementReportId;
        this.studentId = studentId;
        this.description = description;
    }

    public StudentReinforcementReportId getStudentReinforcementReportId() {
        return studentReinforcementReportId;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public Description getDescription() {
        return description;
    }
}
