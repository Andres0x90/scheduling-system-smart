package co.com.sofka.smart.teacher.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.values.TeacherId;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class ChangeWritingTaskTitle extends Command {
    private final TeacherId teacherId;
    private  final WritingTaskId writingTaskId;
    private final Title title;

    public ChangeWritingTaskTitle(TeacherId teacherId, WritingTaskId writingTaskId, Title title) {
        this.teacherId = teacherId;
        this.writingTaskId = writingTaskId;
        this.title = title;
    }
    public TeacherId getTeacherId() {
        return teacherId;
    }
    public WritingTaskId getWritingTaskId() {
        return writingTaskId;
    }

    public Title getTitle() {
        return title;
    }
}
