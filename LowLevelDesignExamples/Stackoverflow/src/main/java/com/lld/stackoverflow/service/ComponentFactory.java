package com.lld.stackoverflow.service;

import com.lld.stackoverflow.model.Vote;
import com.lld.stackoverflow.service.impl.AnswerService;
import com.lld.stackoverflow.service.impl.CommentService;
import com.lld.stackoverflow.service.impl.QuestionService;
import com.lld.stackoverflow.service.impl.VoteService;
import com.lld.stackoverflow.service.interfaces.Actionable;

public class ComponentFactory {

   Actionable fetchService(String action){
        if(action.equals("upvote")){
            return new VoteService();
        }
        if(action.equals("downvote")){
            return new VoteService();
        }
        if(action.equals("answer")){
            return new AnswerService();
        }
        if(action.equals("question")){
            return new QuestionService();
        }
       if(action.equals("comment")){
           return new CommentService();
       }
       return null;
    }
}
