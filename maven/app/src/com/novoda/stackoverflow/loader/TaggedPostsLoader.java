package com.novoda.stackoverflow.loader;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.google.gson.JsonObject;
import com.novoda.stackoverflow.connectivity.CompletedTask;
import com.novoda.stackoverflow.json.StackoverflowPosts;

import java.net.URI;

public class TaggedPostsLoader implements LoaderManager.LoaderCallbacks<CompletedTask> {

    private final Callback callback;
    private final Context context;
    private final URI uri;
    private final LoaderManager loaderManager;
    private final int loaderId;

    public TaggedPostsLoader(Callback callback, Context context, URI uri, LoaderManager loaderManager, int loaderId){

        this.callback = callback;
        this.context = context;
        this.uri = uri;
        this.loaderManager = loaderManager;
        this.loaderId = loaderId;
    }

    public interface Callback {
        void onLoadFinished(JsonObject jsonObject);
    }

    public void restart() {
        loaderManager.restartLoader(loaderId, new Bundle(), this);
    }

    @Override
    public Loader<CompletedTask> onCreateLoader(int i, Bundle bundle) {
        return new StackoverflowLoader(context, uri);
    }

    @Override
    public void onLoadFinished(Loader<CompletedTask> completedTaskLoader, CompletedTask completedTask) {
        if (completedTask.result == CompletedTask.Result.SUCCESS) {
            callback.onLoadFinished(completedTask.jsonObject);
        }
    }

    @Override
    public void onLoaderReset(Loader<CompletedTask> completedTaskLoader) {
    }

}
