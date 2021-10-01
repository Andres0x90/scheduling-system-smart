package co.com.sofka.smart.teacher.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Title;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class WritingTaskTitleChanged extends DomainEvent {
    private  final WritingTaskId writingTaskId;
    private final Title title;

    public WritingTaskTitleChanged(WritingTaskId writingTaskId, Title title) {
        super("smart.teacher.writingtasktitlechanged");
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
