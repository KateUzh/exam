package org.skypro.exam.controller;

import org.skypro.exam.model.Question;
import org.skypro.exam.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class JavaController {
    private final QuestionService questionService;


    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question")
    public Collection<Question> getAllQuestions() {
        return questionService.getAll();
    }

    @DeleteMapping("/question")
    public Collection<Question> remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(question, answer);
    }

    @PostMapping ("/question/{question},{answer}")
    public Collection<Question> add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }
}
