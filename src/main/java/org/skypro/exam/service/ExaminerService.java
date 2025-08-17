package org.skypro.exam.service;

import org.apache.coyote.BadRequestException;
import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws BadRequestException;
}
