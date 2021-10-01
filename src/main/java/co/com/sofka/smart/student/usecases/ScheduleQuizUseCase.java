package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ScheduleQuiz;

public class ScheduleQuizUseCase extends UseCase<RequestCommand<ScheduleQuiz>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ScheduleQuiz> scheduleQuizRequestCommand) {
        var command = scheduleQuizRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.scheduleQuiz(command.getQuizId(),command.getTeacherId(), command.getBook(),
                command.getModule(),command.getDateTaken());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
