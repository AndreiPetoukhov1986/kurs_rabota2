package com.example.kursrabota.service;

import com.example.kursrabota.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions (int amount);
}
