package org.skypro.exam.service;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    @Test
    void giveAmount1_whenGetQuestions() throws BadRequestException {
        int amount = 1;
        when(questionService.getAll()).thenReturn(Set.of(
                new Question("Вопрос1. Насколько велика ссылочная переменная?",
                        "Это неизвестно. Где-то внутри неё есть указатели, но к ним нельзя получить доступ."),
                new Question("Вопрос2. Все ссылки имеют одинаковый размер независимо от " +
                        "величины объекта, на который они ссылаются?", "Да. Все ссылки одной версии JVM будут " +
                        "иметь одинаковый размер.")));

        int result1 = examinerServiceImpl.getQuestions(amount).size();

        assertEquals(1, result1);
    }

    @Test
    void giveAmountLessThenAvailable_whenGetQuestions_thenThrow() throws BadRequestException {
        int amount = 5;
        when(questionService.getAll()).thenReturn(Set.of(
                new Question("Вопрос1. Насколько велика ссылочная переменная?",
                        "Это неизвестно. Где-то внутри неё есть указатели, но к ним нельзя получить доступ."),
                new Question("Вопрос2. Все ссылки имеют одинаковый размер независимо от " +
                        "величины объекта, на который они ссылаются?", "Да. Все ссылки одной версии JVM будут " +
                        "иметь одинаковый размер.")));

        assertThrows(BadRequestException.class, () -> examinerServiceImpl.getQuestions(amount));
    }
}