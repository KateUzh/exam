package org.skypro.exam.service;

import org.skypro.exam.model.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {

    Set<Question> add(String question, String answer);

    Set<Question> remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
