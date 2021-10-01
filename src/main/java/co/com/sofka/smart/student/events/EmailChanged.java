package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.Email;

public class EmailChanged extends DomainEvent {
    private final Email newEmail;

    public EmailChanged(Email newEmail) {
        super("smart.student.emailchanged");
        this.newEmail = newEmail;
    }

    public Email getNewEmail() {
        return newEmail;
    }
}
