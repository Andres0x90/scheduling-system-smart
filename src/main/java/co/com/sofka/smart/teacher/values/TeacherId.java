package co.com.sofka.smart.teacher.values;

import co.com.sofka.domain.generic.Identity;

public class TeacherId extends Identity {
    public TeacherId(String id)
    {
        super(id);
    }
    public TeacherId(){super();}
    public static TeacherId of(String id)
    {
        return new TeacherId(id);
    }
}
