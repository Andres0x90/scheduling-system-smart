package co.com.sofka.smart.teacher;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.smart.teacher.events.TeacherCreated;

public class TeacherChange extends EventChange {
    public TeacherChange(Teacher teacher) {
        apply((TeacherCreated event)->
        {
            teacher.name = event.getName();
            teacher.age = event.getAge();
            teacher.address = event.getAddress();
            teacher.languages = event.getLanguages();
        });
    }
}
