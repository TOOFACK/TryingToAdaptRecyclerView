package com.example.paulr.tryingtoadaptrecyclerview;

import android.os.AsyncTask;
import android.util.Log;

import com.example.paulr.tryingtoadaptrecyclerview.enities.User;
import com.example.paulr.tryingtoadaptrecyclerview.model.api.JsonPlaceholderApi;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class UserTask extends AsyncTask<Void, ArrayList<User>, ArrayList<User>> {

    public AsyncResponse delegate = null;

    public UserTask(AsyncResponse delegate){
        this.delegate = delegate;
    }


    @Override
    protected ArrayList<User> doInBackground(Void... voids) {
        JsonPlaceholderApi api = new JsonPlaceholderApi("https://jsonplaceholder.typicode.com/users/");
        try{
            ArrayList<User> users = api.getUserList();
            Log.d("JsonINAsynv", String.valueOf(users.get(0)));
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }



        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<User> userList)
    {
        delegate.processFinish(userList);
        Log.d("CheckOnPostExcecute", String.valueOf(userList.get(1)));
    }
}
