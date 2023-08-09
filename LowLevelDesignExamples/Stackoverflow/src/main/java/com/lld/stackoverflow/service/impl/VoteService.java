package com.lld.stackoverflow.service.impl;

import com.lld.stackoverflow.model.Vote;
import com.lld.stackoverflow.service.interfaces.Actionable;
import com.lld.stackoverflow.service.interfaces.Notifiable;
import com.lld.stackoverflow.service.model.Action;

public class VoteService implements Actionable<Vote>, Notifiable {
    @Override
    public void post(Vote vote) {
        vote.upVote();
    }

    @Override
    public void notify(Action action) {

    }
}
