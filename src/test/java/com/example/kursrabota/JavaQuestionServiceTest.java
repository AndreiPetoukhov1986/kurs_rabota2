package com.example.kursrabota;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


import com.example.kursrabota.exception.QuestionExistsException;
import com.example.kursrabota.exception.QuestionNoException;
import com.example.kursrabota.exception.QuestionsIsEmptyException;
import com.example.kursrabota.model.Question;
import com.example.kursrabota.service.QuestionService;
import com.example.kursrabota.service.impl.JavaQuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class JavaQuestionServiceTest {


    private QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(new Question("Вопрос 1", "Ответ 1"));
        questionService.add(new Question("Вопрос 2", "Ответ 2"));
        questionService.add(new Question("Вопрос 3", "Ответ 3"));
    }

    @AfterEach
    public void afterEach() {
        new HashSet<>(questionService.getAll()).forEach(questionService::remove);
    }

    @Test
    public void add1Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Вопрос 4", "Ответ 4");

        assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void add2Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Вопрос 5", "Ответ 5");

        assertThat(questionService.add("Вопрос 5", "Ответ 5"))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void addNegative1Test() {
        Question question = new Question("Вопрос 1", "Ответ 1");

        assertThatExceptionOfType(QuestionExistsException.class)
                .isThrownBy(() -> questionService.add(question));
    }

    @Test
    public void addNegative2Test() {
        assertThatExceptionOfType(QuestionExistsException.class)
                .isThrownBy(() -> questionService.add("Вопрос 2", "Ответ 2"));
    }

    @Test
    public void removeTest() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Вопрос 2", "Ответ 2");

        assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void removeNegativeTest() {
        assertThatExceptionOfType(QuestionNoException.class)
                .isThrownBy(() -> questionService.remove(new Question("Вопрос 4", "Ответ 4")));
    }

    @Test
    public void getAllTest() {
        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Вопрос 1", "Ответ 1"),
                        new Question("Вопрос 2", "Ответ 2"),
                        new Question("Вопрос 3", "Ответ 3")
                );
    }

    @Test
    public void getRandomQuestionTest(){
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }

    @Test
    public void getRandomQuestionNegativeTest(){
        afterEach();
        assertThatExceptionOfType(QuestionsIsEmptyException.class)
                .isThrownBy(questionService::getRandomQuestion);
    }


}
