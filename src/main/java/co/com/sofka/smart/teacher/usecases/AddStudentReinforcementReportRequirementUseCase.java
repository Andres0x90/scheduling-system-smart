package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.AddStudentReinforcementReportRequirement;

public class AddStudentReinforcementReportRequirementUseCase extends UseCase<
        RequestCommand<AddStudentReinforcementReportRequirement>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddStudentReinforcementReportRequirement>
                                           addStudentReinforcementReportRequirementRequestCommand)
    {
        var command =
                addStudentReinforcementReportRequirementRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.addStudentReinforcementReportRequirement(command.getStudentReinforcementReportId(),
                command.getRequirement());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
