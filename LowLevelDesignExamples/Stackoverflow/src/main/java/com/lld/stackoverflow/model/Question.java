package com.lld.stackoverflow.model;

import lombok.Data;

import java.util.List;

@Data
public class Question extends Component{
    private List<Comment> commentList;
    private List<Answer> answerList;
    private List<String> tags;
}
