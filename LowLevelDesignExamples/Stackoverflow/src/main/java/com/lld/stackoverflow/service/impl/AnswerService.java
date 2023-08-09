package com.lld.stackoverflow.service.impl;

import com.lld.stackoverflow.model.Answer;
import com.lld.stackoverflow.service.interfaces.Actionable;
import com.lld.stackoverflow.service.interfaces.Notifiable;
import com.lld.stackoverflow.service.model.Action;

public class AnswerService implements Actionable<Answer>, Notifiable {
    @Override
    public void post(Answer answer) {
        //crux logic of what happens when an answer is posted by an user
    }

    @Override
    public void notify(Action action) {

    }
}
