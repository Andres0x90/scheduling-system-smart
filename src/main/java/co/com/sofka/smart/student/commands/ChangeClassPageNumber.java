package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.ClassId;
import co.com.sofka.smart.student.values.PageNumber;

public class ChangeClassPageNumber extends Command {
    private final ClassId classId;
    private final PageNumber newPageNumber;

    public ChangeClassPageNumber(ClassId classId, PageNumber newPageNumber) {
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
