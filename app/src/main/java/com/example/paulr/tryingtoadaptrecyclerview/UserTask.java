package com.example.paulr.tryingtoadaptrecyclerview;

import android.os.AsyncTask;
import android.util.Log;

import com.example.paulr.tryingtoadaptrecyclerview.enities.User;
import com.example.paulr.tryingtoadaptrecyclerview.model.api.AsyncResponse;
import com.example.paulr.tryingtoadaptrecyclerview.model.api.JsonPlaceholderApi;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class UserTask extends AsyncTask<Void, Void, ArrayList<User>> {

    public AsyncResponse delegate = null;

    public UserTask(AsyncResponse delegate){
        this.delegate = delegate;
    }


    @Override
    protected ArrayList<User> doInBackground(Void... voids) {
        JsonPlaceholderApi api = new JsonPlaceholderApi("https://jsonplaceholder.typicode.com/users");
        try {
            ArrayList<User> usersListFromMethod = api.getUserList();
            return usersListFromMethod;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<User> userList)
    {
        delegate.processFinish(userList);
    }
}
