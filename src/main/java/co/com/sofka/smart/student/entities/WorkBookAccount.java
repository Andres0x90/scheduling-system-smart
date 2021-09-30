package co.com.sofka.smart.student.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.student.values.Email;
import co.com.sofka.smart.student.values.Password;
import co.com.sofka.smart.student.values.Username;
import co.com.sofka.smart.student.values.WorkBookAccountId;

public class WorkBookAccount extends Entity<WorkBookAccountId> {
    private Username username;
    private Password password;
    private Email email;

    public WorkBookAccount(WorkBookAccountId workBookAccountId, Username username,
                           Password password, Email email) {
        super(workBookAccountId);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void changePassword(Password newPassword)
    {
        this.password = newPassword;
    }
    public void updateEmail(Email newEmail)
    {
        this.email = newEmail;
    }

    public Username username() {
        return username;
    }

    public Password password() {
        return password;
    }

    public Email email() {
        return email;
    }
}
