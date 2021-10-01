package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.PageNumber;

public class ClassPageNumberChanged extends DomainEvent {
    private final ClassId classId;
    private final PageNumber newPageNumber;

    public ClassPageNumberChanged(ClassId classId, PageNumber newPageNumber) {
        super("smart.student.classpagenumberchanged");
        this.classId = classId;
        this.newPageNumber = newPageNumber;
    }

    public ClassId getClassId() {
        return classId;
    }

    public PageNumber getNewPageNumber() {
        return newPageNumber;
    }
}
