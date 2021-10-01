package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.CreateTeacher;

public class CreateTeacherUseCase extends UseCase<RequestCommand<CreateTeacher>, ResponseEvents>
{
    @Override
    public void executeUseCase(RequestCommand<CreateTeacher> createTeacherRequestCommand) {
        var command = createTeacherRequestCommand.getCommand();
        var teacher = new Teacher(command.getTeacherId(), command.getName(),
                command.getAge(), command.getAddress(), command.getLanguages());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}

