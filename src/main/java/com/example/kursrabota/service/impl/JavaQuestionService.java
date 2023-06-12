package com.example.kursrabota.service.impl;

import com.example.kursrabota.exception.QuestionExistsException;
import com.example.kursrabota.exception.QuestionNoException;
import com.example.kursrabota.exception.QuestionsIsEmptyException;
import com.example.kursrabota.model.Question;
import com.example.kursrabota.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions =new HashSet<>();
    Random random=new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!questions.remove(question)){
            throw new QuestionNoException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return  Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if(questions.isEmpty()){
            throw new QuestionsIsEmptyException();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
