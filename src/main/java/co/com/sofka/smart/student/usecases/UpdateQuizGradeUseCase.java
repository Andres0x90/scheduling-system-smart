package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.UpdateQuizGrade;

public class UpdateQuizGradeUseCase extends UseCase<RequestCommand<UpdateQuizGrade>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateQuizGrade> updateQuizGradeRequestCommand) {
        var command = updateQuizGradeRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.updateQuizGrade(command.getQuizId(),command.getNewScore());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
