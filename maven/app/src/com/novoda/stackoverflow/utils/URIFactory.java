package com.novoda.stackoverflow.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIUtils;

public class URIFactory {

    private static final String SCHEME = "https";
    private static final String HOST = "api.stackexchange.com";
    private static final int DEFAULT_PORT = -1;

    private static URI createUri(String path) {
        return prepareURI(path, null);
    }

    private static URI prepareURI(String path, String query) {
        try {
            return URIUtils.createURI(SCHEME, HOST, DEFAULT_PORT, path, query, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static URI searchByTag(String searchedTag) {
        return createUri(new StringBuilder("/2.1/search?order=desc&sort=activity&tagged=").append(searchedTag).append("&site=stackoverflow").toString());
    }
}
