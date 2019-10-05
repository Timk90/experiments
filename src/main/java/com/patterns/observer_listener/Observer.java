package com.patterns.observer_listener;

public interface Observer<T> {

    public void update(T state);
}
