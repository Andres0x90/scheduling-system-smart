package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.CreateStudentReinforcementReport;

public class CreateStudentReinforcementReportUseCase extends UseCase<
        RequestCommand<CreateStudentReinforcementReport>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateStudentReinforcementReport>
                                           createStudentReinforcementReportRequestCommand)
    {
        var command = createStudentReinforcementReportRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.createStudentReinforcementReport(command.getStudentReinforcementReportId(),
                command.getStudentId(), command.getDescription());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
