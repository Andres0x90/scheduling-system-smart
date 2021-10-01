package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;
import co.com.sofka.smart.teacher.values.TeacherId;

public class CreateStudentReinforcementReport extends Command {
    private final TeacherId teacherId;
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final StudentId studentId;
    private final Description description;

    public CreateStudentReinforcementReport(TeacherId teacherId, StudentReinforcementReportId studentReinforcementReportId,
                                             StudentId studentId, Description description) {
        this.teacherId = teacherId;
        this.studentReinforcementReportId = studentReinforcementReportId;
        this.studentId = studentId;
        this.description = description;
    }
    public TeacherId getTeacherId() {
        return teacherId;
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
