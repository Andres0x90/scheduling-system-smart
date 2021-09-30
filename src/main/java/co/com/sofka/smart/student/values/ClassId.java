package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.Identity;

public class ClassId extends Identity {
    public ClassId(String id)
    {
        super(id);
    }
    public ClassId(){super();}
    public static ClassId of(String id)
    {
        return new ClassId(id);
    }
}
