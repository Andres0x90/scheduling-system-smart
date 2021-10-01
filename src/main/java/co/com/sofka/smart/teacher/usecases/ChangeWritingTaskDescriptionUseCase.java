package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.ChangeWritingTaskDescription;
import co.com.sofka.smart.teacher.commands.ChangeWritingTaskTitle;

public class ChangeWritingTaskDescriptionUseCase extends UseCase<RequestCommand<ChangeWritingTaskDescription>
        , ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ChangeWritingTaskDescription> changeWritingTaskDescriptionRequestCommand) {
        var command = changeWritingTaskDescriptionRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.changeWritingTaskDescription(command.getWritingTaskId(), command.getDescription());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
