package com.novoda.stackoverflow.json;

import java.io.*;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;

public class JsonWorker {

    public static String readFrom(HttpResponse response) {
        StringBuilder inputStringBuilder = new StringBuilder();
        try {
            InputStream data = new GZIPInputStream(response.getEntity().getContent());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data, "UTF-8"));
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStringBuilder.toString();
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
