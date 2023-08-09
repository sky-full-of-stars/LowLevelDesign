package com.lld.stackoverflow.service.interfaces;

import com.lld.stackoverflow.service.model.Action;

public interface Notifiable {
    void notify(Action action);
}
