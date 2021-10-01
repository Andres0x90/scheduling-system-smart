package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.ChangeStudentReinforcementReportDescription;

public class ChangeStudentReinforcementReportDescriptionUseCase extends UseCase<
        RequestCommand<ChangeStudentReinforcementReportDescription>, ResponseEvents>
{
    @Override
    public void executeUseCase(RequestCommand<ChangeStudentReinforcementReportDescription>
                                           changeStudentReinforcementReportDescriptionRequestCommand) {
        var command =
                changeStudentReinforcementReportDescriptionRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.changeStudentReinforcementReportDescription(command.getStudentReinforcementReportId(),
                command.getDescription());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
