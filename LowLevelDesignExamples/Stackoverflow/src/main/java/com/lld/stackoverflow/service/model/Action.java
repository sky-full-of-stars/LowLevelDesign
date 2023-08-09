package com.lld.stackoverflow.service.model;

import lombok.Data;

@Data
public class Action {
    private String userId;
    private String actionPerformedComponentId;
    private String actionPerformed;
}
