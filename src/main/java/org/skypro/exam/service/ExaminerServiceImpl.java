package org.skypro.exam.service;

import org.apache.coyote.BadRequestException;
import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService;
    Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws BadRequestException {
        Set<Question> result = new HashSet<>();
        if (amount <= questionService.getAll().size()) {
            int i = 0;
            while (result.size() < amount) {
                result.add(questionService.getRandomQuestion());
                i++;
            }
        } else throw new BadRequestException("Вопросов должно быть не больше " + questionService.getAll().size());
        return result;
    }
}
