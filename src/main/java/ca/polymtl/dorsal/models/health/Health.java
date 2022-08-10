package ca.polymtl.dorsal.models.health;

public class Health {
    private HealthStatus status;

    public Health(HealthStatus status) {
        this.status = status;
    }

    public HealthStatus getStatus() {
        return status;
    }

    public void setStatus(HealthStatus status) {
        this.status = status;
    }
}
