package com.lld.stackoverflow.model;

import lombok.Data;

import java.util.Date;

@Data
public class Component {
    private Long id;
    private String desc;
    private Date postedOn;
    private User postedBy;
    private Date lastEditedOn;
    private Vote vote;
}
