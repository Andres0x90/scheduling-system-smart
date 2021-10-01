package co.com.sofka.smart.teacher.values;

import co.com.sofka.domain.generic.Identity;

public class WritingTaskId extends Identity {
    public WritingTaskId(String id)
    {
        super(id);
    }
    public WritingTaskId(){super();}
    public static WritingTaskId of(String id)
    {
        return new WritingTaskId(id);
    }
}
