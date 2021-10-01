package co.com.sofka.smart.student.storage;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.student.events.StudentCreated;
import co.com.sofka.smart.student.values.*;

import java.util.List;

public class StudentStorage {
    public static List<DomainEvent> getStudentData()
    {
        return List.of(
                new StudentCreated(
                        new StudentId("xxx-xxx"),
                        new Name("Andres Mauricio", "Cano Causil"),
                        new Age("19"),
                        new Address("Calle", "116A", "83-42", "Las brisas"),
                        new Username("Andres0x90"),
                        new Password("1234"),
                        new Email("andrescaza246@hotmail.com"),
                        new Signature("Andres M Cano")
                )
        );
    }
}
