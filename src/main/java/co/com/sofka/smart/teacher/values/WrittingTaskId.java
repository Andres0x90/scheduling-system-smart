package co.com.sofka.smart.teacher.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.smart.student.values.QuizId;

public class WrittingTaskId extends Identity {
    public WrittingTaskId(String id)
    {
        super(id);
    }
    public WrittingTaskId(){super();}
    public static WrittingTaskId of(String id)
    {
        return new WrittingTaskId(id);
    }
}
