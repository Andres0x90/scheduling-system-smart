package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.ChangeWritingTaskTitle;

public class ChangeWritingTaskTitleUseCase extends UseCase<RequestCommand<ChangeWritingTaskTitle>,
        ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeWritingTaskTitle> changeWritingTaskTitleRequestCommand) {
        var command = changeWritingTaskTitleRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.changeWritingTaskTitle(command.getWritingTaskId(), command.getTitle());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
