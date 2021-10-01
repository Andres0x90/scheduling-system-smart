package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.Password;
import co.com.sofka.smart.student.values.Username;
import co.com.sofka.smart.student.values.WorkBookAccountId;

public class WorkBookAccountCreated extends DomainEvent {
    private final WorkBookAccountId workBookAccountId;
    private final  Username username;
    private final Password password;
    private final Email email;

    public WorkBookAccountCreated(WorkBookAccountId workBookAccountId, Username username,
                                  Password password, Email email) {
        super("smart.student.workbookaccountcreated");
        this.workBookAccountId = workBookAccountId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public WorkBookAccountId getWorkBookAccountId() {
        return workBookAccountId;
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }
}
