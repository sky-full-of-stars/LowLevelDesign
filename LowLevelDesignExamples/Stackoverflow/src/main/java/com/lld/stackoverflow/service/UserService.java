package com.lld.stackoverflow.service;

import com.lld.stackoverflow.model.Answer;
import com.lld.stackoverflow.model.Vote;
import com.lld.stackoverflow.repos.ComponentInventory;

public class UserService {
    ComponentFactory componentFactory = new ComponentFactory();

    public void upVote(Long componentId) {
        Vote vote = new ComponentInventory().findById(componentId).getVote();
        componentFactory.fetchService("upvote").post(vote);
    }

    public void downVote(Long componentId){

    }

    public void answerQuestion(Long componentId, Answer answer){

    }
}
