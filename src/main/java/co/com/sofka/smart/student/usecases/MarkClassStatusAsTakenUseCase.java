package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.MarkClassStatusAsTaken;

public class MarkClassStatusAsTakenUseCase extends UseCase<RequestCommand<MarkClassStatusAsTaken>
        , ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<MarkClassStatusAsTaken> markClassStatusAsTakenRequestCommand) {
        var command = markClassStatusAsTakenRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.markClassStatusAsTaken(command.getClassId());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
