package hcmus.advanced_db.log_generator.runner;

public interface IRunner {
    public abstract void sendMetrics();
    public abstract void sendHeartBeat();
}
