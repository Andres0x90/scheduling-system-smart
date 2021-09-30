package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.Identity;

public class WorkBookAccountId extends Identity {
    public WorkBookAccountId(String id)
    {
        super(id);
    }
    public WorkBookAccountId(){super();}
    public static WorkBookAccountId of(String id)
    {
        return new WorkBookAccountId(id);
    }
}
