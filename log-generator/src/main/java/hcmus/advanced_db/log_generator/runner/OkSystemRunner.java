package hcmus.advanced_db.log_generator.runner;

public class OkSystemRunner implements IRunner {

    @Override
    public void sendMetrics() {
        System.out.println("OK Metrics");
    }

    @Override
    public void sendHeartBeat() {
        System.out.println("OK HeartBeat");
    }
}
