package com.lld.stackoverflow.model;

import lombok.Data;

@Data
public class Vote {
    private Long upvoteCount;
    private Long downvoteCount;

    public void upVote(){
        upvoteCount++;
    }
    public void downVote(){
        downvoteCount++;
    }
}
