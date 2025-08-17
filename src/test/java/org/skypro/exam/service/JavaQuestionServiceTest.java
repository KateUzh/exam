package org.skypro.exam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.exam.model.Question;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private Set<Question> questions;
    @Mock
    private Map<Integer, Question> questionsWithNumber;
    @Mock
    private Random random;
    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    void giveQuestion_whenCreateQuestionsWithNumberInMap_thenQuestionCreate() {
        when(questionsWithNumber.put(1, new Question("Вопрос1", "Ответ"))).thenReturn
                (new Question("Вопрос1", "Ответ"));

        Question result = questionsWithNumber.put(1, new Question("Вопрос1", "Ответ"));

        Assertions.assertEquals(new Question("Вопрос1", "Ответ"), result);

    }

    @Test
    void giveQuestion_whenAdd_thenQuestionAdd() {
        String question = "question";
        String answer = "answer";

        Set<Question> result = javaQuestionService.add(question, answer);

        Assertions.assertEquals(14, result.size());
    }

    @Test
    void givenNonexistentQuestion_whenRemove_thenQuestionNotRemove() {

        Set<Question> result = javaQuestionService.remove("D", "df");

        Assertions.assertEquals(13, result.size());
    }

    @Test
    void givenQuestion_whenRemove_thenQuestionRemove() {

        Set<Question> result = javaQuestionService.remove("Вопрос4. Какие виды переменных существуют?",
                "df");

        Assertions.assertEquals(12, result.size());
    }

    @Test
    void getAllTest() {

        Collection<Question> result = javaQuestionService.getAll();

        Assertions.assertEquals(13, result.size());
    }

    @Test
    void giveRandomIs5_whenGetRandomQuestion_thenReturn6() {
        when(questionsWithNumber.size()).thenReturn(13);
        when(random.nextInt(questionsWithNumber.size())).thenReturn(5);

        int randomNum = random.nextInt(questionsWithNumber.size()) + 1;

        Assertions.assertEquals(6, randomNum);
    }
}