package co.com.sofka.smart.teacher.values;

import co.com.sofka.domain.generic.Identity;

public class StudentReinforcementReportId extends Identity {
    public StudentReinforcementReportId(String id)
    {
        super(id);
    }
    public StudentReinforcementReportId(){super();}
    public static StudentReinforcementReportId of(String id)
    {
        return new StudentReinforcementReportId(id);
    }
}
