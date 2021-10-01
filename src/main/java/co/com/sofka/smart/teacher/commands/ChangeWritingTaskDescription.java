package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.teacher.values.TeacherId;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class ChangeWritingTaskDescription extends Command {
    private final TeacherId teacherId;
    private final WritingTaskId writingTaskId;
    private final Description description;

    public ChangeWritingTaskDescription(TeacherId teacherId, WritingTaskId writingTaskId, Description description) {
        this.teacherId = teacherId;
        this.writingTaskId = writingTaskId;
        this.description = description;
    }
    public TeacherId getTeacherId() {
        return teacherId;
    }
    public WritingTaskId getWritingTaskId() {
        return writingTaskId;
    }

    public Description getDescription() {
        return description;
    }
}
