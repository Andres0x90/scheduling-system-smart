package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.teacher.values.Requirement;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;
import co.com.sofka.smart.teacher.values.TeacherId;

public class RemoveStudentReinforcementReportRequirement extends Command {
    private final TeacherId teacherId;
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final Requirement requirement;

    public RemoveStudentReinforcementReportRequirement(TeacherId teacherId, StudentReinforcementReportId
            studentReinforcementReportId, Requirement requirement) {
        this.teacherId = teacherId;
        this.studentReinforcementReportId = studentReinforcementReportId;
        this.requirement = requirement;
    }
    public TeacherId getTeacherId() {
        return teacherId;
    }
    public StudentReinforcementReportId getStudentReinforcementReportId() {
        return studentReinforcementReportId;
    }

    public Requirement getRequirement() {
        return requirement;
    }
}
