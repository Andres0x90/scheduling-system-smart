package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.ClassId;

public class ClassStatusAsTakenMarked extends DomainEvent {
    private final ClassId classId;

    public ClassStatusAsTakenMarked(ClassId classId) {
        super("smart.student.classstatusastakenmarked");
        this.classId = classId;
    }

    public ClassId getClassId() {
        return classId;
    }
}
