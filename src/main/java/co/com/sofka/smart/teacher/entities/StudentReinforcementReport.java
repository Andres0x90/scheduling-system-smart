package co.com.sofka.smart.teacher.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.student.values.StudentId;
import co.com.sofka.smart.teacher.values.Requirement;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;

import java.util.ArrayList;
import java.util.List;

public class StudentReinforcementReport extends Entity<StudentReinforcementReportId>
{
    private StudentId studentId;
    private Description description;
    private List<Requirement> requirements;

    public StudentReinforcementReport(StudentReinforcementReportId studentReinforcementReportId,
                                      StudentId studentId, Description description
                                      ) {
        super(studentReinforcementReportId);
        this.studentId = studentId;
        this.description = description;
        this.requirements = new ArrayList<>();
    }

    public void updateDescription(Description description)
    {
        this.description = description;
    }
    public void addRequirement(Requirement requirement)
    {
        this.requirements.add(requirement);
    }
    public void removeRequirement(Requirement requirement)
    {
        this.requirements.stream().filter(requirementFilter ->
                !requirementFilter.value().equals(requirement.value()));
    }

    public StudentId studentId() {
        return studentId;
    }

    public Description description() {
        return description;
    }

    public List<Requirement> requirements() {
        return requirements;
    }
}
