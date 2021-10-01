package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ScheduleClass;

public class ScheduleClassUseCase extends UseCase<RequestCommand<ScheduleClass>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ScheduleClass> scheduleClassRequestCommand) {
        var command = scheduleClassRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.scheduleClass(command.getClassId(), command.getBook(), command.getModule(),
                command.getPageNumber(), command.getStatus(), command.getDateTaken());

        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
