package co.com.sofka.smart.student.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.smart.student.values.AgreementId;
import co.com.sofka.smart.student.values.Condition;
import co.com.sofka.smart.student.values.DateTaken;
import co.com.sofka.smart.student.values.Signature;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Agreement extends Entity<AgreementId> {
    private final Calendar calendar = Calendar.getInstance();

    private List<Condition> conditions;
    private DateTaken periodOfValidity;
    private Signature signature;

    public Agreement(AgreementId agreementId, List<Condition> conditions, Signature signature) {
        super(agreementId);
        this.conditions = conditions;
        this.signature = signature;
        this.assignPeriodOfValidity();
    }

    private void assignPeriodOfValidity()
    {
        Date currentDate = new Date();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, 1);
        Date limitDate = calendar.getTime();

        this.periodOfValidity = new DateTaken(currentDate, limitDate);
    }

    public void updatePeriodOfValidity()
    {
        calendar.setTime(periodOfValidity.value().endDate());
        calendar.add(Calendar.YEAR, 1);
        this.periodOfValidity = new DateTaken(periodOfValidity.value().startDate(),
                calendar.getTime());
    }

    public List<Condition> conditions() {
        return conditions;
    }

    public DateTaken periodOfValidity() {
        return periodOfValidity;
    }

    public Signature signature() {
        return signature;
    }
}
