package co.com.sofka.smart.student;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.smart.student.values.StudentId;

public class Student extends AggregateEvent<StudentId> {
    public Student(StudentId entityId) {
        super(entityId);
    }
}
