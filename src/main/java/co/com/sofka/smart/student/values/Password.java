package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

public class Password implements ValueObject<String> {

    private final PasswordEncoder hasher;
    private final String value;

    public Password(String value) {
        Objects.requireNonNull(value, "El campo contraseña es requerido");
        this.hasher = new BCryptPasswordEncoder();
        this.value = hasher.encode(value);
    }

    @Override
    public String value() {
        return value;
    }
}
