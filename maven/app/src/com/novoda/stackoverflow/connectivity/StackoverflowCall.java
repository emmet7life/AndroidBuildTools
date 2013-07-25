package com.novoda.stackoverflow.connectivity;

import android.util.Log;

import com.novoda.stackoverflow.json.JsonWorker;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

public class StackoverflowCall implements SimpleHttpCaller.SimpleHttpCallerCallback {

    public interface StackoverflowCallCallback {
        void onStackoverflowCallSuccess(String json);

        void onStackoverflowCallFailure();

        void onStackoverflowCallError();
    }

    private final URI callUri;
    protected final StackoverflowCallCallback callback;
    private final DefaultHttpClient httpClient;

    public StackoverflowCall(URI callUri, StackoverflowCallCallback callback) {
        this.callUri = callUri;
        this.callback = callback;
        this.httpClient = HttpClientFactory.getThreadSafeClient();
    }

    public void execute() {
        try {
            buildHttpGetCaller().execute();
        } catch (final Exception e) {
            Log.e(StackoverflowCall.class.getSimpleName(), "HttpClient exception for uri " + callUri.toString() + "\n"+ e.toString());
            callback.onStackoverflowCallError();
        }
    }

    protected SimpleHttpCaller buildHttpGetCaller() throws Exception {
        HttpGet request = new HttpGet(callUri);
        request.addHeader(new BasicHeader("Accept", "application/json, text/javascript, */*"));
        request.addHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
        return new SimpleHttpCaller(httpClient, request, this);
    }

    @Override
    public void onSimpleHttpCallSuccess(HttpResponse response) {
        String json = JsonWorker.readFrom(response);
        callback.onStackoverflowCallSuccess(json);
    }

    @Override
    public void onSimpleHttpCallFailure(HttpResponse response) throws _403Exception {
        callback.onStackoverflowCallFailure();
    }

    @SuppressWarnings("serial")
    public static class _403Exception extends IOException {
    }
}
