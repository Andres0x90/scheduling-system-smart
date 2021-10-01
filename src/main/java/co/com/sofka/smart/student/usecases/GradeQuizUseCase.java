package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.GradeQuiz;

public class GradeQuizUseCase extends UseCase<RequestCommand<GradeQuiz>, ResponseEvents>
{
    @Override
    public void executeUseCase(RequestCommand<GradeQuiz> gradeQuizRequestCommand) {
        var command = gradeQuizRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.gradeQuiz(command.getQuizId(),command.getScore());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
