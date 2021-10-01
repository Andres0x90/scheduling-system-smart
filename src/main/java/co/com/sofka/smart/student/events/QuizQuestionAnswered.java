package co.com.sofka.smart.student.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.smart.student.values.Item;
import co.com.sofka.smart.student.values.QuizId;

public class QuizQuestionAnswered extends DomainEvent {
    private final QuizId quizId;
    private final Item item;

    public QuizQuestionAnswered(QuizId quizId, Item item) {
        super("smart.student.quizquestionanswered");
        this.quizId = quizId;
        this.item = item;
    }

    public QuizId getQuizId() {
        return quizId;
    }

    public Item getItem() {
        return item;
    }
}
