package com.lld.stackoverflow.model;

import lombok.Data;

import java.util.List;

@Data
public class Answer extends Component{
    private List<Comment> commentList;
}
