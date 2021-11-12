package com.example.expose.push_notif_utils;

public interface Observer<T> {
    void handle (PropertyChangedEventArgs<T> args);
}