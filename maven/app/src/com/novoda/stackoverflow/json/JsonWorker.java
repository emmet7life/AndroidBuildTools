package com.novoda.stackoverflow.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;

public class JsonWorker {

    public static JsonObject jsonFrom(HttpResponse response) {
        Reader reader = getJSONReader(response);
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(jsonReader).getAsJsonObject();
        close(reader);
        return jsonResponse;
    }

    private static Reader getJSONReader(HttpResponse response) {
        Reader reader = null;
        try {
            InputStream data = new GZIPInputStream(response.getEntity().getContent());
            reader = new InputStreamReader(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    private static void close(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
