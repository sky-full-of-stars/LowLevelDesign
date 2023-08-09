package com.lld.stackoverflow.model;

import com.lld.stackoverflow.service.UserService;
import lombok.Data;

import java.util.List;

@Data
public class User extends Person{
    private String id;
    private Long reputations;
    private List<Badge> badgeList;
    private List<Question> questionList;
    private List<Answer> answerList;
    private List<Comment> commentList;

    void upvote(Long componentId, Vote vote) {
        UserService service = new UserService();
        service.upVote(componentId, vote);
    }
}
