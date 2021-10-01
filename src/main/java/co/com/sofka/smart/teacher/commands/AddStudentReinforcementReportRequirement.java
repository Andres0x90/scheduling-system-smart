package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.teacher.values.Requirement;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

public class AddStudentReinforcementReportRequirement extends Command {
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final Requirement requirement;

    public AddStudentReinforcementReportRequirement(StudentReinforcementReportId studentReinforcementReportId,
                                                      Requirement requirement) {
        this.studentReinforcementReportId = studentReinforcementReportId;
        this.requirement = requirement;
    }

    public StudentReinforcementReportId getStudentReinforcementReportId() {
        return studentReinforcementReportId;
    }

    public Requirement getRequirement() {
        return requirement;
    }
}
