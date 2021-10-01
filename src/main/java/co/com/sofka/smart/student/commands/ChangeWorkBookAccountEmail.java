package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Email;

public class ChangeWorkBookAccountEmail extends Command {
    private final Email newEmail;

    public ChangeWorkBookAccountEmail(Email newEmail) {
        this.newEmail = newEmail;
    }

    public Email getNewEmail() {
        return newEmail;
    }
}
