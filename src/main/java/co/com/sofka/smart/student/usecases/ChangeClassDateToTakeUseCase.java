package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeClassDateToTake;

public class ChangeClassDateToTakeUseCase extends UseCase<RequestCommand<ChangeClassDateToTake>,
        ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeClassDateToTake> changeClassDateToTakeRequestCommand) {
        var command = changeClassDateToTakeRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.changeClassDateToTake(command.getClassId(),command.getDateTaken());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
