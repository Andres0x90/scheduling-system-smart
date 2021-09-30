package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.Identity;

public class StudentId extends Identity {
    public StudentId(String id)
    {
        super(id);
    }
    public StudentId(){super();}
    public static StudentId of(String id)
    {
        return new StudentId(id);
    }
}
