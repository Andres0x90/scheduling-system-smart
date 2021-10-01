package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.AnswerQuizQuestion;

public class AnswerQuizQuestionUseCase extends UseCase<RequestCommand<AnswerQuizQuestion>, ResponseEvents>
{
    @Override
    public void executeUseCase(RequestCommand<AnswerQuizQuestion> answerQuizQuestionRequestCommand) {
        var command = answerQuizQuestionRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.answerQuizQuestion(command.getQuizId(),command.getItem());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
