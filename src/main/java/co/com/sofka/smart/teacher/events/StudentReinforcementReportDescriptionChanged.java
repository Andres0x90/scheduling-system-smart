package co.com.sofka.smart.teacher.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

public class StudentReinforcementReportDescriptionChanged extends DomainEvent {
   private final StudentReinforcementReportId studentReinforcementReportId;
   private final Description description;

    public StudentReinforcementReportDescriptionChanged(StudentReinforcementReportId studentReinforcementReportId,
                                                        Description description) {
        super("smart.teacher.studentreinforcementreportdescriptionchanged");
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
