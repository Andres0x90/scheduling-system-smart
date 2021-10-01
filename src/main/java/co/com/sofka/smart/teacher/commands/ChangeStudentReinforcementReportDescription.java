package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

public class ChangeStudentReinforcementReportDescription extends Command {
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final Description description;

    public ChangeStudentReinforcementReportDescription(StudentReinforcementReportId studentReinforcementReportId,
                                                        Description description) {
        this.studentReinforcementReportId = studentReinforcementReportId;
        this.description = description;
    }

    public StudentReinforcementReportId getStudentReinforcementReportId() {
        return studentReinforcementReportId;
    }

    public Description getDescription() {
        return description;
    }
}
