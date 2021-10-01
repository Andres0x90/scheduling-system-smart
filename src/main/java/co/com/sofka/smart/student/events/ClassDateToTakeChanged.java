package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;

public class ClassDateToTakeChanged extends DomainEvent {
    private final ClassId classId;
    private final DateTaken dateTaken;

    public ClassDateToTakeChanged(ClassId classId, DateTaken dateTaken) {
        super("smart.student.classdatetotakechanged");
        this.classId = classId;
        this.dateTaken = dateTaken;
    }

    public ClassId getClassId() {
        return classId;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
