package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ResetWorkBookAccountPassword;

public class ResetPasswordUseCase extends UseCase<RequestCommand<ResetWorkBookAccountPassword>,
        ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ResetWorkBookAccountPassword> resetWorkBookAccountPasswordRequestCommand) {
        var command = resetWorkBookAccountPasswordRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.resetWorkBookAccountPassword(command.getNewPassword());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
