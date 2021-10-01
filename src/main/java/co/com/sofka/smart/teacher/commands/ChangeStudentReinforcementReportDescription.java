package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;
import co.com.sofka.smart.teacher.values.TeacherId;

public class ChangeStudentReinforcementReportDescription extends Command {
    private final TeacherId teacherId;
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final Description description;

    public ChangeStudentReinforcementReportDescription(TeacherId teacherId,
                                     StudentReinforcementReportId studentReinforcementReportId,
                                     Description description) {
        this.teacherId = teacherId;
        this.studentReinforcementReportId = studentReinforcementReportId;
        this.description = description;
    }
    public TeacherId getTeacherId() {
        return teacherId;
    }
    public StudentReinforcementReportId getStudentReinforcementReportId() {
        return studentReinforcementReportId;
    }

    public Description getDescription() {
        return description;
    }
}
