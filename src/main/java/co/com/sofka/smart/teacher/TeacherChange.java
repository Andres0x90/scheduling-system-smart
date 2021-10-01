package co.com.sofka.smart.teacher;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.smart.teacher.entities.StudentReinforcementReport;
import co.com.sofka.smart.teacher.entities.WritingTask;
import co.com.sofka.smart.teacher.events.*;
import co.com.sofka.smart.teacher.values.StudentReinforcementReportId;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class TeacherChange extends EventChange {

    public WritingTask findWritingTaskById(Teacher teacher, WritingTaskId writingTaskId)
    {
        return teacher.writingTasks.stream().filter(writingTask ->
                writingTask.identity().value().equals(writingTaskId.value())).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    public StudentReinforcementReport findStudentReinforcementReportById(Teacher teacher,
                            StudentReinforcementReportId studentReinforcementReportIdId)
    {
        return teacher.studentReinforcementReports.stream().filter(studentReinforcementReport ->
                        studentReinforcementReport
                                .identity().value().equals(studentReinforcementReportIdId.value())).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public TeacherChange(Teacher teacher) {
        apply((TeacherCreated event)->
        {
            teacher.name = event.getName();
            teacher.age = event.getAge();
            teacher.address = event.getAddress();
            teacher.languages = event.getLanguages();
        });
        apply((WritingTaskCreated event)->
        {
            teacher.writingTasks.add(new WritingTask(event.getWritingTaskId(), event.getTitle(),
                    event.getDescription(), event.getBook(), event.getModule()));
        });
        apply((WritingTaskTitleChanged event)->
        {
            var writingTask = findWritingTaskById(teacher, event.getWritingTaskId());
            writingTask.updateTitle(event.getTitle());
        });
        apply((WritingTaskDescriptionChanged event)->
        {
            var writingTask = findWritingTaskById(teacher, event.getWritingTaskId());
            writingTask.updateDescription(event.getDescription());
        });
        apply((StudentReinforcementReportCreated event)->
        {
            teacher.studentReinforcementReports.add(
                    new StudentReinforcementReport(event.getStudentReinforcementReportId(),
                            event.getStudentId(), event.getDescription())
            );
        });
        apply((StudentReinforcementReportDescriptionChanged event)->
        {
            var studentReinforcementReport = findStudentReinforcementReportById(
                    teacher, event.getStudentReinforcementReportId()
            );
            studentReinforcementReport.updateDescription(event.getDescription());
        });
        apply((StudentReinforcementReportRequirementAdded event)->
        {
            var studentReinforcementReport = findStudentReinforcementReportById(
                    teacher, event.getStudentReinforcementReportId()
            );
            studentReinforcementReport.addRequirement(event.getRequirement());
        });
        apply((StudentReinforcementReportRequirementRemoved event)->
        {
            var studentReinforcementReport = findStudentReinforcementReportById(
                    teacher, event.getStudentReinforcementReportId()
            );
            studentReinforcementReport.removeRequirement(event.getRequirement());
        });
    }
}
