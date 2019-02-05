package com.example.paulr.tryingtoadaptrecyclerview.model.api;


import com.example.paulr.tryingtoadaptrecyclerview.enities.User;

import java.util.ArrayList;

public interface AsyncResponse {
    void processFinish(ArrayList<User> users);
}