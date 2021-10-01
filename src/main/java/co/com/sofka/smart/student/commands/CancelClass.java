package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.StudentId;

public class CancelClass extends Command {

    private final StudentId studentId;
    private final ClassId classId;

    public CancelClass(StudentId studentId, ClassId classId) {
        this.studentId = studentId;
        this.classId = classId;
    }

    public StudentId getStudentId() {
        return studentId;
    }
    public ClassId getClassId() {
        return classId;
    }
}
