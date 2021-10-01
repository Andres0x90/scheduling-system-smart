package co.com.sofka.smart.student.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.smart.student.Student;
import co.com.sofka.smart.student.commands.ExtendAgreementPeriodOfValidity;

public class ExtendAgreementPeriodOfValidityUseCase extends UseCase<RequestCommand<ExtendAgreementPeriodOfValidity>,
        ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ExtendAgreementPeriodOfValidity> extendAgreementPeriodOfValidityUseCaseRequestCommand) {
        var command = extendAgreementPeriodOfValidityUseCaseRequestCommand.getCommand();
        this.setIdentify(command.getStudentId().value());
        var student = Student.from(command.getStudentId(), this.retrieveEvents());
        student.extendAgreementPeriodOfValidity();
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
