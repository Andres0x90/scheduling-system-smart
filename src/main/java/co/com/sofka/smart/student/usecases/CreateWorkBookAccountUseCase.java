package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.CreateWorkBookAccount;

public class CreateWorkBookAccountUseCase extends UseCase<RequestCommand<CreateWorkBookAccount>, ResponseEvents>
{

    @Override
    public void executeUseCase(RequestCommand<CreateWorkBookAccount> createWorkBookAccountRequestCommand) {
        var command = createWorkBookAccountRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.createWorkBookAccount(command.getWorkBookAccountId(), command.getUsername(),
                command.getPassword(), command.getEmail());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}

