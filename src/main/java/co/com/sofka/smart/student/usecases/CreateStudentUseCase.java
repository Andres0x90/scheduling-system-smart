package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.CreateStudent;

public class CreateStudentUseCase extends UseCase<RequestCommand<CreateStudent>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateStudent> createStudentRequestCommand) {
        var command = createStudentRequestCommand.getCommand();
        var student = new Student(command.getStudentId(), command.getName(),
                command.getAge(), command.getAddress(), command.getUsername(), command.getPassword(),
                command.getEmail(), command.getSignature());

        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }

}
