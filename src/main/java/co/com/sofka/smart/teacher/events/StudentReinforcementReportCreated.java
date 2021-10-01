package co.com.sofka.smart.teacher.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

public class StudentReinforcementReportCreated extends DomainEvent {
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final StudentId studentId;
    private final Description description;

    public StudentReinforcementReportCreated(StudentReinforcementReportId studentReinforcementReportId,
                                             StudentId studentId, Description description) {
        super("smart.teacher.studentreinforcementreportcreated");
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
