package org.skypro.exam.controller;

import org.apache.coyote.BadRequestException;
import org.skypro.exam.model.Question;
import org.skypro.exam.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/question/{amount}")
    public Collection<Question> getQuestions(@RequestParam int amount) throws BadRequestException {
        return examinerService.getQuestions(amount);
    }

}
