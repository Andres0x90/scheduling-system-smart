package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.ClassId;

public class CancelClass extends Command {
    private final ClassId classId;
    public CancelClass(ClassId classId) {
        this.classId = classId;
    }

    public ClassId getClassId() {
        return classId;
    }
}
