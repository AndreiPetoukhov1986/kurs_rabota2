package com.example.kursrabota;

import com.example.kursrabota.exception.IncorrectAmountOfQuestionsEcxeption;
import com.example.kursrabota.model.Question;
import com.example.kursrabota.service.QuestionService;
import com.example.kursrabota.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImpTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Collection<Question> questions = Set.of(
            new Question("Вопрос 1", "Ответ 1"),
            new Question("Вопрос 2", "Ответ 2"),
            new Question("Вопрос 3", "Ответ 3"),
            new Question("Вопрос 4", "Ответ 4"),
            new Question("Вопрос 5", "Ответ 5")
    );

    @Test
    public void getQuestionsNegativeTest() {
        when(questionService.getAll()).thenReturn(questions);
        assertThatExceptionOfType(IncorrectAmountOfQuestionsEcxeption.class)
                .isThrownBy(() -> examinerService.getQuestions((questions.size() + 1)));
        assertThatExceptionOfType(IncorrectAmountOfQuestionsEcxeption.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
    }

    @Test
    public void getQuestionsTest() {
        when(questionService.getAll()).thenReturn(questions);

        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 3", "Ответ 3"),
                new Question("Вопрос 5", "Ответ 5")
        );
        assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Вопрос 1", "Ответ 1"),
                        new Question("Вопрос 5", "Ответ 5"),
                        new Question("Вопрос 3", "Ответ 3")
                );
    }

}
