package org.eclipse.tsp.java.client.core.restclient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PclConnectionStatus implements PropertyChangeListener {
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        final String expectedPropertyName = "status";
        if (event.getPropertyName() == expectedPropertyName) {
            this.status = (Boolean) event.getNewValue();
        }
    }
}
