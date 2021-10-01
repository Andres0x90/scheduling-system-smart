package co.com.sofka.smart.student;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.smart.student.entities.Agreement;
import co.com.sofka.smart.student.entities.Class;
import co.com.sofka.smart.student.entities.Quiz;
import co.com.sofka.smart.student.entities.WorkBookAccount;
import co.com.sofka.smart.student.events.*;
import co.com.sofka.smart.student.values.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentChange extends EventChange {
    public Class findClassById(Student student, ClassId classId)
    {
        return student.classes.stream().filter(classStudent ->
            classStudent.identity().value().equals(classId.value())
        ).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Quiz findQuizById(Student student, QuizId quizId)
    {
        return student.quizzes.stream().filter(quizStudent ->
                quizStudent.identity().equals(quizId)
        ).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public StudentChange(Student student) {
        apply((StudentCreated event)->
        {
            List<Condition> conditions = new ArrayList<>();
            conditions.add(new Condition("Asistir a todas las clases"));
            conditions.add(new Condition("Pasar todas las evaluaciones para obtener un certificado"));
            conditions.add(new Condition("Pagar mensualmente la cuota de 1 millon de pesos"));

            student.name = event.getName();
            student.age = event.getAge();
            student.address = event.getAddress();
            student.workBookAccount = new WorkBookAccount(new WorkBookAccountId(),
                    event.getUsername(), event.getPassword(), event.getEmail());
            student.agreement = new Agreement(new AgreementId(), conditions);
            student.agreement.sign(event.getSignature());
            student.classes = new ArrayList<>();
            student.quizzes = new ArrayList<>();
        });
        apply((PersonalDataChanged event)->
        {
            student.name = event.getName();
            student.age = event.getAge();
            student.address = event.getAddress();
        });
        apply((ClassScheduled event)->
        {
            student.classes.add(new Class(event.getClassId(), event.getBook(), event.getModule(),
                    event.getPageNumber(), event.getDateTaken()));
        });
        apply((ClassCanceled event) ->
        {
            var studentClass = findClassById(student, event.getClassId());
            studentClass.updateStatus(new Status("CANCELADA"));
        });
        apply((ClassPageNumberChanged event)->
        {
            var studentClass = findClassById(student, event.getClassId());
            studentClass.updatePageNumber(event.getNewPageNumber());

        });
        apply((ClassStatusAsTakenMarked event)->
        {
            var studentClass = findClassById(student, event.getClassId());
            studentClass.updateStatus(new Status("FINALIZADA"));
        });
        apply((ClassDateToTakeChanged event)->
        {
            var studentClass = findClassById(student, event.getClassId());
            studentClass.updateDate(event.getDateTaken());
        });
        apply((WorkBookAccountCreated event)->
        {
            student.workBookAccount = new WorkBookAccount(event.getWorkBookAccountId(),
                    event.getUsername(), event.getPassword(), event.getEmail());
        });
        apply((PasswordReseted event)->
        {
            Objects.requireNonNull(student.workBookAccount,
                    "Debe asociar una cuenta de workbook primero");
            student.workBookAccount.changePassword(event.getNewPassword());
        });
        apply((EmailChanged event)->
        {
            Objects.requireNonNull(student.workBookAccount,
                    "Debe asociar una cuenta de workbook primero");
            student.workBookAccount.updateEmail(event.getNewEmail());
        });
        apply((AgreementPeriodOfValidityExtended event)->
        {
            Objects.requireNonNull(student.agreement,
                    "Necesita poder tener un contrato para ser estudiante");

            student.agreement.updatePeriodOfValidity();
        });
        apply((QuizScheduled event)->
        {
            student.quizzes.add(new Quiz(event.getQuizId(), event.getTeacherId(), event.getBook(),
                    event.getModule(), event.getDateTaken(), new Status("PROGRAMADO")));
        });
        apply((QuizDateToTakeChanged event)->
        {
            var studentQuiz = findQuizById(student, event.getQuizId());
            studentQuiz.updateDate(event.getDateTaken());
        });
        apply((QuizQuestionAnswered event) ->
        {
            var studentQuiz = findQuizById(student, event.getQuizId());
            studentQuiz.addAnswer(event.getItem().value().question(), event.getItem().value().answer());
        });
        apply((QuizGraded event)->
        {
            var studentQuiz = findQuizById(student, event.getQuizId());
            studentQuiz.assignScore(event.getScore().value(),
                    new Status("CALIFICADO"));
        });
        apply((QuizGradeUpdated event)->
        {
            var studentQuiz = findQuizById(student, event.getQuizId());
            studentQuiz.updateScore(event.getNewScore().value(),
                    new Status("CALIFICACION CAMBIADA"));
        });
    }
}
