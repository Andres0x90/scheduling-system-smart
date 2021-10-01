package co.com.sofka.smart.student;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.generic.values.Address;
import co.com.sofka.smart.generic.values.Age;
import co.com.sofka.smart.generic.values.Book;
import co.com.sofka.smart.generic.values.Name;
import co.com.sofka.smart.student.entities.Agreement;
import co.com.sofka.smart.student.entities.Class;
import co.com.sofka.smart.student.entities.Quiz;
import co.com.sofka.smart.student.entities.WorkBookAccount;
import co.com.sofka.smart.student.events.*;
import co.com.sofka.smart.student.values.*;
import co.com.sofka.smart.teacher.values.TeacherId;

import java.util.ArrayList;
import java.util.List;

public class Student extends AggregateEvent<StudentId> {
    protected Name name;
    protected Age age;
    protected Address address;
    protected WorkBookAccount workBookAccount;
    protected Agreement agreement;
    List<Class>classes;
    List<Quiz>quizzes;

    public Student(StudentId studentId, Name name, Age age, Address address, Username username,
                   Password password, Email email, Signature signature) {
        super(studentId);

        appendChange(new StudentCreated(studentId, name, age, address, username, password,
                email, signature)).apply();
    }
    private Student(StudentId studentId) {
        super(studentId);
        subscribe(new StudentChange(this));
    }

    public static Student from(StudentId studentId, List<DomainEvent> events) {
        var student = new Student(studentId);
        events.forEach(student::applyEvent);
        return student;
    }

    public void changePersonalData(Name name, Age age, Address address)
    {
        appendChange(new PersonalDataChanged(name, age, address)).apply();
    }

    public void scheduleClass(ClassId classId, Book book, Module module, PageNumber pageNumber,
                              Status status, DateTaken dateTaken)
    {
        appendChange(new ClassScheduled(classId, book, module, pageNumber, status, dateTaken))
                .apply();
    }
    public void cancelClass(ClassId classId)
    {
        appendChange(new ClassCanceled(classId)).apply();
    }
    public void changeClassPageNumber(ClassId classId, PageNumber newPageNumber)
    {
        appendChange(new ClassPageNumberChanged(classId, newPageNumber)).apply();
    }
    public void markClassStatusAsTaken(ClassId classId)
    {
        appendChange(new ClassStatusAsTakenMarked(classId)).apply();
    }
    public void changeClassDateToTake(ClassId classId, DateTaken dateTaken)
    {
        appendChange(new ClassDateToTakeChanged(classId, dateTaken)).apply();
    }
    public void createWorkBookAccount(WorkBookAccountId workBookAccountId,Username username,
                                      Password password, Email email)
    {
        appendChange(new WorkBookAccountCreated(workBookAccountId, username, password, email)).apply();
    }
    public void resetWorkBookAccountPassword(Password newPassword)
    {
        appendChange(new PasswordReseted(newPassword)).apply();
    }
    public void changeWorkBookAccountEmail(Email newEmail)
    {
        appendChange(new EmailChanged(newEmail)).apply();
    }
    public void extendAgreementPeriodOfValidity()
    {
        appendChange(new AgreementPeriodOfValidityExtended()).apply();
    }
    public void scheduleQuiz(QuizId quizId, TeacherId teacherId, Book book, Module module,
                             DateTaken dateTaken, Status status){
        appendChange(new QuizScheduled(quizId, teacherId, book, module, dateTaken)).apply();
    }
    public void changeQuizDateToTake(QuizId quizId, DateTaken dateTaken)
    {
        appendChange(new QuizDateToTakeChanged(quizId, dateTaken)).apply();
    }
    public  void answerQuizQuestion(QuizId quizId, Item item)
    {
        appendChange(new QuizQuestionAnswered(quizId, item)).apply();
    }
    public void gradeQuiz(QuizId quizId, Score score)
    {
        appendChange(new QuizGraded(quizId, score)).apply();
    }
    public void updateQuizGrade(QuizId quizId, Score newScore)
    {
        appendChange(new QuizGradeUpdated(quizId, newScore));
    }
    public Name name() {
        return name;
    }

    public Age age() {
        return age;
    }

    public Address address() {
        return address;
    }

    public WorkBookAccount workBookAccount() {
        return workBookAccount;
    }

    public Agreement agreement() {
        return agreement;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }
}
