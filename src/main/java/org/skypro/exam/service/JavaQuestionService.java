package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Map<Integer, Question> questionsWithNumber;
    Random random = new Random();

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.questionsWithNumber = new HashMap<>();
        createQuestionsWithNumberInMap();
        createQuestionsWithOutNumberInSet();
    }

    public void createQuestionsWithNumberInMap() {
        questionsWithNumber.put(1, new Question("Вопрос1. Насколько велика ссылочная переменная?",
                "Это неизвестно. Где-то внутри неё есть указатели, но к ним нельзя получить доступ."));
        questionsWithNumber.put(2, new Question("Вопрос2. Все ссылки имеют одинаковый размер независимо от " +
                "величины объекта, на который они ссылаются?", "Да. Все ссылки одной версии JVM будут иметь " +
                "одинаковый размер."));
        questionsWithNumber.put(3, new Question("Вопрос3. Можно ли выполнять арифметические операции со " +
                "ссылочными переменными?", "Нет."));
        questionsWithNumber.put(4, new Question("Вопрос4. Какие виды переменных существуют?",
                "Существует два типа переменных: примитивы (простые типы) и ссылки."));
        questionsWithNumber.put(5, new Question("Вопрос5. Какое значение имеет ссылочная переменная, " +
                "если она не ссылается ни на какой объект?", "Null."));
        questionsWithNumber.put(6, new Question("Вопрос6. В чём разница между for и while?", "Цикл while" +
                " содержит только условие и не предусматривает встроенной инициализации или итерационного выражения."));
        questionsWithNumber.put(7, new Question("Вопрос7. Что такое инкапсуляция?", "Концепция, " +
                "согласно которой мы не даём доступ к свойствам объекта, а получаем их значения через методы."));
        questionsWithNumber.put(8, new Question("Вопрос8. Какие примитивные типы данных существуют?",
                "Целочисленный, с плавающей точкой, символьный, логический."));
        questionsWithNumber.put(9, new Question("Вопрос9. Какие принципы ООП называют основными?",
                "Инкапсуляция, наследование, полиморфизм."));
        questionsWithNumber.put(10, new Question("Вопрос10. Как называется метод, с помощью которого можно " +
                "изменить или задать значение переменной?", "Сеттер."));
        questionsWithNumber.put(11, new Question("Вопрос11. Что такое исключение?",
                "Ситуация, которая может возникнуть во время выполнения программы и привести к остановке ее " +
                        "работы."));
        questionsWithNumber.put(12, new Question("Вопрос12. Что такое функциональный интерфейс в Java?",
                "Это интерфейс, который содержит только один абстрактный метод. При этом число статических " +
                        "и дефолтных методов не ограничено."));
        questionsWithNumber.put(13, new Question("Вопрос13. Что такое лямбда-выражение?",
                "Анонимная реализация какого-то метода функционального интерфейса."));
    }

    private void createQuestionsWithOutNumberInSet() {
        questions.addAll(questionsWithNumber.values());
    }

    @Override
    public Set<Question> add(String question, String answer) {
        questions.add(new Question(question,answer));
        return questions;
    }

    @Override
    public Set<Question> remove(String question, String answer) {
        questions.removeIf(elem ->
                elem.getQuestion().equalsIgnoreCase(question)
        );
        return questions;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Question result = null;
        int randomNum = random.nextInt(questionsWithNumber.size()) +1;
        if (questionsWithNumber.containsKey(randomNum) && questionsWithNumber.get(randomNum) !=null) {
            result = questionsWithNumber.get(randomNum);
        }
        return result;
    }
}
