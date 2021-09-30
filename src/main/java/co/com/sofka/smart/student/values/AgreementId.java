package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.Identity;

public class AgreementId extends Identity {
    public AgreementId(String id)
    {
        super(id);
    }
    public AgreementId(){super();}
    public static AgreementId of(String id)
    {
        return new AgreementId(id);
    }
}
