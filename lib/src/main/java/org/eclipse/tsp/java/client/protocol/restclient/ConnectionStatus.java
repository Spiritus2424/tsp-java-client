package org.eclipse.tsp.java.client.protocol.restclient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ConnectionStatus {
    private boolean status;
    private PropertyChangeSupport support;

    public ConnectionStatus() {
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.removePropertyChangeListener(propertyChangeListener);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.support.firePropertyChange("status", this.status, status);
        this.status = status;
    }

}
