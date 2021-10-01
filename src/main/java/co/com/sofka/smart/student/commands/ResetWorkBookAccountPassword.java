package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Password;

public class ResetWorkBookAccountPassword extends Command {
    private final Password newPassword;

    public ResetWorkBookAccountPassword(Password newPassword) {
        this.newPassword = newPassword;
    }

    public Password getNewPassword() {
        return newPassword;
    }
}
