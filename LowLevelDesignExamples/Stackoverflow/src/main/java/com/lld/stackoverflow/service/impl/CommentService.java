package com.lld.stackoverflow.service.impl;

import com.lld.stackoverflow.model.Comment;
import com.lld.stackoverflow.service.interfaces.Actionable;
import com.lld.stackoverflow.service.interfaces.Notifiable;
import com.lld.stackoverflow.service.model.Action;

public class CommentService implements Actionable<Comment>, Notifiable {
    @Override
    public void post(Comment comment) {

    }

    @Override
    public void notify(Action action) {

    }
}