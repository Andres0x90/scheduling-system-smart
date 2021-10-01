package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;

public class ChangeClassDateToTake extends Command {
    private final ClassId classId;
    private final DateTaken dateTaken;

    public ChangeClassDateToTake(ClassId classId, DateTaken dateTaken) {
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
