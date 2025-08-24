package org.skypro.exam.service;

import org.skypro.exam.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random random = new Random();

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        createQuestions();
    }

    public void createQuestions() {
        questions.add(new Question("Вопрос1. Насколько велика ссылочная переменная?",
                "Это неизвестно. Где-то внутри неё есть указатели, но к ним нельзя получить доступ."));
        questions.add(new Question("Вопрос2. Все ссылки имеют одинаковый размер независимо от " +
                "величины объекта, на который они ссылаются?", "Да. Все ссылки одной версии JVM будут иметь " +
                "одинаковый размер."));
        questions.add(new Question("Вопрос3. Можно ли выполнять арифметические операции со " +
                "ссылочными переменными?", "Нет."));
        questions.add(new Question("Вопрос4. Какие виды переменных существуют?",
                "Существует два типа переменных: примитивы (простые типы) и ссылки."));
        questions.add(new Question("Вопрос5. Какое значение имеет ссылочная переменная, " +
                "если она не ссылается ни на какой объект?", "Null."));
        questions.add(new Question("Вопрос6. В чём разница между for и while?", "Цикл while" +
                " содержит только условие и не предусматривает встроенной инициализации или итерационного выражения."));
        questions.add(new Question("Вопрос7. Что такое инкапсуляция?", "Концепция, " +
                "согласно которой мы не даём доступ к свойствам объекта, а получаем их значения через методы."));
        questions.add(new Question("Вопрос8. Какие примитивные типы данных существуют?",
                "Целочисленный, с плавающей точкой, символьный, логический."));
        questions.add(new Question("Вопрос9. Какие принципы ООП называют основными?",
                "Инкапсуляция, наследование, полиморфизм."));
        questions.add(new Question("Вопрос10. Как называется метод, с помощью которого можно " +
                "изменить или задать значение переменной?", "Сеттер."));
        questions.add(new Question("Вопрос11. Что такое исключение?",
                "Ситуация, которая может возникнуть во время выполнения программы и привести к остановке ее " +
                        "работы."));
        questions.add(new Question("Вопрос12. Что такое функциональный интерфейс в Java?",
                "Это интерфейс, который содержит только один абстрактный метод. При этом число статических " +
                        "и дефолтных методов не ограничено."));
        questions.add(new Question("Вопрос13. Что такое лямбда-выражение?",
                "Анонимная реализация какого-то метода функционального интерфейса."));
    }

    @Override
    public Set<Question> add(String question, String answer) {
        if (questions.contains(new Question(question, answer))) {
            throw new IllegalArgumentException("Такой вопрос уже есть.");
        }
        questions.add(new Question(question, answer));
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
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomNum = random.nextInt(questions.size());
        return questions.stream().skip(randomNum).findFirst().orElse(null);
    }
}
