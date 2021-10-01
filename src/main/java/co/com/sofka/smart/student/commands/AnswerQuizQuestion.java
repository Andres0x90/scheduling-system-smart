package co.com.sofka.smart.student.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.smart.student.values.Item;
import co.com.sofka.smart.student.values.QuizId;

public class AnswerQuizQuestion extends Command {
    private final QuizId quizId;
    private final Item item;

    public AnswerQuizQuestion(QuizId quizId, Item item) {
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
