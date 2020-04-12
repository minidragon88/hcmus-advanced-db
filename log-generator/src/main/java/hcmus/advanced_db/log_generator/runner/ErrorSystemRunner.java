package hcmus.advanced_db.log_generator.runner;

public class ErrorSystemRunner implements IRunner {

    @Override
    public void sendMetrics() {
        System.out.println("Error Metrics");
    }

    @Override
    public void sendHeartBeat() {
        System.out.println("Error HeartBeat");
    }
}
