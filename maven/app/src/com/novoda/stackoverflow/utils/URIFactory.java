package com.novoda.stackoverflow.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIUtils;

public class URIFactory {

    private static final String SCHEME = "https";
    private static final String HOST = "api.stackexchange.com";
    private static final int DEFAULT_PORT = -1;

    private URI prepareURI(String path) {
        return prepareURI(path, null);
    }

    private URI prepareURI(String path, String query) {
        try {
            return URIUtils.createURI(SCHEME, HOST, DEFAULT_PORT, path, query, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public URI searchByTag(String searchedTag) {
        return prepareURI("/2.1/search?order=desc&sort=activity&tagged=" + searchedTag + "&site=stackoverflow");
    }
}
