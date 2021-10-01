package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.Password;
import co.com.sofka.smart.student.values.Username;
import co.com.sofka.smart.student.values.WorkBookAccountId;

public class CreateWorkBookAccount extends Command {
    private final WorkBookAccountId workBookAccountId;
    private final Username username;
    private final Password password;
    private final Email email;

    public CreateWorkBookAccount(WorkBookAccountId workBookAccountId, Username username,
                                  Password password, Email email) {
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
