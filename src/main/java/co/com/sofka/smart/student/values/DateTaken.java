package co.com.sofka.smart.student.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class DateTaken implements ValueObject<DateTaken.props> {

    private final Date startDate;
    private final Date endDate;

    public DateTaken(Date startDate, Date endDate) {
        this.startDate = Objects.requireNonNull(startDate, "El campo fecha de inicio es requerido");
        this.endDate = Objects.requireNonNull(endDate ,
                "El campo fecha de finalizacion es requerido");
    }

    @Override
    public props value() {
        return new props() {
            @Override
            public Date startDate() {
                return startDate;
            }

            @Override
            public Date endDate() {
                return endDate;
            }
        };
    }

    public interface props {
        Date startDate();
        Date endDate();
    }
}
