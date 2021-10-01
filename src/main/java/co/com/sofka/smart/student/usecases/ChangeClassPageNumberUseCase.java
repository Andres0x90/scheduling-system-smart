package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.CancelClass;
import co.com.sofka.smart.student.commands.ChangeClassPageNumber;

public class ChangeClassPageNumberUseCase extends UseCase<RequestCommand<ChangeClassPageNumber>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeClassPageNumber> changeClassPageNumber) {
        var command = changeClassPageNumber.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.changeClassPageNumber(command.getClassId(), command.getNewPageNumber());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}