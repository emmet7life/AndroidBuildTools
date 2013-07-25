package com.novoda.stackoverflow.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.novoda.stackoverflow.connectivity.CompletedTask;
import com.novoda.stackoverflow.connectivity.StackoverflowCall;

import java.net.URI;

public class StackoverflowLoader extends AsyncTaskLoader<CompletedTask> implements StackoverflowCall.StackoverflowCallCallback {

    private final StackoverflowCall serverCall;
    private CompletedTask completedTask;

    public StackoverflowLoader(Context context, URI uri) {
        super(context);
        serverCall = new StackoverflowCall(uri, this);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public CompletedTask loadInBackground() {
        serverCall.execute();
        return completedTask;
    }

    @Override
    public void onStackoverflowCallSuccess(String json) {
        completedTask = new CompletedTask(CompletedTask.Result.SUCCESS, json);
    }

    @Override
    public void onStackoverflowCallFailure() {
        completedTask = new CompletedTask(CompletedTask.Result.FAILURE);
    }

    @Override
    public void onStackoverflowCallError() {

    }
}
