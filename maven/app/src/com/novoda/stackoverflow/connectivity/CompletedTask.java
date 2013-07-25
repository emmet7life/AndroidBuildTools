package com.novoda.stackoverflow.connectivity;

public class CompletedTask {

    public enum Result {
        SUCCESS, ERROR, FAILURE, OFFLINE, SERVER_FAILURE
    }

    public final Result result;
    public final Throwable exception;
    public final String json;
    public int loaderID;

    public CompletedTask(Result result) {
        this.result = result;
        this.exception = null;
        this.json = null;
    }

    public CompletedTask(Result result, Throwable exception) {
        this.result = result;
        this.exception = exception;
        this.json = null;
    }

    public CompletedTask(Result result, String json) {
        this.result = result;
        this.exception = null;
        this.json = json;
    }

    public int getLoaderID() {
        return loaderID;
    }

    public void setLoaderID(int loaderID) {
        this.loaderID = loaderID;
    }
}
