package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ChangeQuizDateToTake;

public class ChangeQuizDateToTakeUseCase extends UseCase<RequestCommand<ChangeQuizDateToTake>,
        ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeQuizDateToTake> changeQuizDateToTakeRequestCommand) {
        var command = changeQuizDateToTakeRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.changeQuizDateToTake(command.getQuizId(),command.getDateTaken());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
