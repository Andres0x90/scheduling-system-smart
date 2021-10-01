package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;

public class AgreementPeriodOfValidityExtended extends DomainEvent {
    public AgreementPeriodOfValidityExtended() {
        super("smart.student.agreementperiodofvalidityextended");
    }
}
