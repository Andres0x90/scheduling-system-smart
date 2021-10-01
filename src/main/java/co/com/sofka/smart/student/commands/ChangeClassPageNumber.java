package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.PageNumber;
import co.com.sofka.smart.student.values.StudentId;

public class ChangeClassPageNumber extends Command {
    private final StudentId studentId;
    private final ClassId classId;
    private final PageNumber newPageNumber;

    public ChangeClassPageNumber(StudentId studentId, ClassId classId, PageNumber newPageNumber) {
        this.studentId = studentId;
        this.classId = classId;
        this.newPageNumber = newPageNumber;
    }
    public StudentId getStudentId() {
        return studentId;
    }

    public ClassId getClassId() {
        return classId;
    }

    public PageNumber getNewPageNumber() {
        return newPageNumber;
    }
}
