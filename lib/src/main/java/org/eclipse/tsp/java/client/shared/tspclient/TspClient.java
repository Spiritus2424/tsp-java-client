package org.eclipse.tsp.java.client.shared.tspclient;

import lombok.Getter;

public class TspClient {
    @Getter
    private String baseUrl;

    public TspClient(String baseUrl) {
        this.baseUrl = String.format("%s/tsp/api", baseUrl);
    }
}
