package co.com.sofka.smart.teacher.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.teacher.Teacher;
import co.com.sofka.smart.teacher.commands.CreateWritingTask;

public class CreateWritingTaskUseCase extends UseCase<RequestCommand<CreateWritingTask>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateWritingTask> createWritingTaskRequestCommand) {
        var command = createWritingTaskRequestCommand.getCommand();
        this.setIdentify(command.getTeacherId().value());
        var teacher = Teacher.from(command.getTeacherId(), this.retrieveEvents());
        teacher.createWritingTask(command.getWritingTaskId(), command.getTitle(),command.getDescription(),
                command.getBook(), command.getModule());

        emit().onResponse(new ResponseEvents(teacher.getUncommittedChanges()));
    }
}
