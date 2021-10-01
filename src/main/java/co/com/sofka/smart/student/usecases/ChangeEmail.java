package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeWorkBookAccountEmail;

public class ChangeEmail extends UseCase<RequestCommand<ChangeWorkBookAccountEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeWorkBookAccountEmail> changeEmailRequestCommand) {
        var command = changeEmailRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.changeWorkBookAccountEmail(command.getNewEmail());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
