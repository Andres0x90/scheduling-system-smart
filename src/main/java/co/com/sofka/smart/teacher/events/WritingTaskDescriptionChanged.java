package co.com.sofka.smart.teacher.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Description;
import co.com.sofka.smart.teacher.values.WritingTaskId;

public class WritingTaskDescriptionChanged extends DomainEvent {
    private final WritingTaskId writingTaskId;
    private final Description description;

    public WritingTaskDescriptionChanged(WritingTaskId writingTaskId, Description description) {
        super("smart.teacher,writingtaskdescriptionchanged");
        this.writingTaskId = writingTaskId;
        this.description = description;
    }

    public WritingTaskId getWritingTaskId() {
        return writingTaskId;
    }

    public Description getDescription() {
        return description;
    }
}
