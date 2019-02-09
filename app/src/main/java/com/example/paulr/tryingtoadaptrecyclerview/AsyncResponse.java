package com.example.paulr.tryingtoadaptrecyclerview;


import com.example.paulr.tryingtoadaptrecyclerview.enities.User;

import java.util.ArrayList;

public interface AsyncResponse {
    void processFinish(ArrayList<User> users);
}