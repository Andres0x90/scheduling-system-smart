package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.RemoveStudentReinforcementReportRequirement;

public class RemoveStudentReinforcementReportRequirementUseCase extends UseCase<
        RequestCommand<RemoveStudentReinforcementReportRequirement>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveStudentReinforcementReportRequirement>
                                           removeStudentReinforcementReportRequirementRequestCommand)
    {
        var command =
                removeStudentReinforcementReportRequirementRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.removeStudentReinforcementReportRequirement(command.getStudentReinforcementReportId(),
                command.getRequirement());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
