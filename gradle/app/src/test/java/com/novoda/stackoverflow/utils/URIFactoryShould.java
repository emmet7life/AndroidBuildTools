package com.novoda.stackoverflow.utils;

import java.net.URI;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class URIFactoryShould {

    private static final String ANY_TAG = "anyTag";
    private static final String EXPECTED_SEARCH_TAG = "https://api.stackexchange.com/2.1/search?order=desc&sort=activity&tagged=" + ANY_TAG + "&site=stackoverflow";

    @Test
    public void returnSearchUriForTagSearch() throws Exception {
        URIFactory uriFactory = new URIFactory();
        URI actualSearchTagUri = uriFactory.searchByTag(ANY_TAG);
        assertEquals(actualSearchTagUri, new URI(EXPECTED_SEARCH_TAG));
    }
}
