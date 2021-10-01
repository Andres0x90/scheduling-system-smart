package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.CancelClass;

public class CancelClassUseCase extends UseCase<RequestCommand<CancelClass>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CancelClass> cancelClassRequestCommand) {
        var command = cancelClassRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.cancelClass(command.getClassId());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
