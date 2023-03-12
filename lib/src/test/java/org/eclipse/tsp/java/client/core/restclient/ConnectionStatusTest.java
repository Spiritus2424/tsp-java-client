package org.eclipse.tsp.java.client.core.restclient;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ConnectionStatusTest {
    @Test
    public void statusIsTrue() {
        ConnectionStatus connectionStatus = new ConnectionStatus();
        PclConnectionStatus pclConnectionStatus = new PclConnectionStatus();
        connectionStatus.addPropertyChangeListener(pclConnectionStatus);
        connectionStatus.setStatus(true);
        assertTrue(pclConnectionStatus.isStatus());
    }

    @Test
    public void statusIsFalse() {
        ConnectionStatus connectionStatus = new ConnectionStatus();
        PclConnectionStatus pclConnectionStatus = new PclConnectionStatus();
        connectionStatus.addPropertyChangeListener(pclConnectionStatus);
        connectionStatus.setStatus(false);
        assertTrue(!pclConnectionStatus.isStatus());
    }
}
