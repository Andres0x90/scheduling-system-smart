package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.StudentId;

public class ChangeClassDateToTake extends Command {
    private final StudentId studentId;
    private final ClassId classId;
    private final DateTaken dateTaken;

    public ChangeClassDateToTake(StudentId studentId, ClassId classId, DateTaken dateTaken) {
        this.studentId = studentId;
        this.classId = classId;
        this.dateTaken = dateTaken;
    }
    public StudentId getStudentId() {
        return studentId;
    }
    public ClassId getClassId() {
        return classId;
    }

    public DateTaken getDateTaken() {
        return dateTaken;
    }
}
