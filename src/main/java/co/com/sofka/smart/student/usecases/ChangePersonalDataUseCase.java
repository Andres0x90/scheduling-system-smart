package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangePersonalData;

public class ChangePersonalDataUseCase extends UseCase<RequestCommand<ChangePersonalData>, ResponseEvents>
{
    @Override
    public void executeUseCase(RequestCommand<ChangePersonalData> changePersonalDataRequestCommand) {
        var command = changePersonalDataRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.changePersonalData(command.getName(), command.getAge(),
                command.getAddress());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
