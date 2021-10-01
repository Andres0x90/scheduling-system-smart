package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class ChangeWritingTaskTitle extends Command {
    private  final WritingTaskId writingTaskId;
    private final Title title;

    public ChangeWritingTaskTitle(WritingTaskId writingTaskId, Title title) {
        this.writingTaskId = writingTaskId;
        this.title = title;
    }

    public WritingTaskId getWritingTaskId() {
        return writingTaskId;
    }

    public Title getTitle() {
        return title;
    }
}
