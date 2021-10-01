package co.com.sofka.smart.teacher.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.teacher.values.Requirement;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

public class StudentReinforcementReportRequirementRemoved extends DomainEvent {
    private final StudentReinforcementReportId studentReinforcementReportId;
    private final Requirement requirement;

    public StudentReinforcementReportRequirementRemoved(StudentReinforcementReportId studentReinforcementReportId,
                                                      Requirement requirement) {
        super("smart.teacher.studentreinforcementreportrequirementremoved");
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
