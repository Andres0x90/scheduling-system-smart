package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.ClassId;

public class ClassCanceled extends DomainEvent {
    private final ClassId classId;
    public ClassCanceled(ClassId classId) {
        super("smart.student.classcanceled");
        this.classId = classId;
    }

    public ClassId getClassId() {
        return classId;
    }
}
