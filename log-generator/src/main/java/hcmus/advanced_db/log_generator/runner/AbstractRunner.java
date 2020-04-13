package hcmus.advanced_db.log_generator.runner;

import com.google.gson.JsonObject;

import hcmus.advanced_db.log_generator.Constants;
import hcmus.advanced_db.log_generator.OutputMode;
import hcmus.advanced_db.log_generator.model.HostDetail;
import hcmus.advanced_db.log_generator.model.ProcessDetail;
import hcmus.advanced_db.log_generator.runner.output.IOutput;
import hcmus.advanced_db.log_generator.runner.output.RestOutput;

public abstract class AbstractRunner {
    protected IOutput output;
    protected HostDetail hostDetail;
    public AbstractRunner(final OutputMode outputMode) {
        this.hostDetail = HostDetail.newHostDetail();
        switch (outputMode) {
        default:
            output = new RestOutput();
            break;
        }
    }
    
    protected abstract void changeStateAndSendData(int currentLoop);
    
    public void process() {
        // Send the initial values
        sendMetrics();
        sendHeartBeat();
        for (int currentLoop = 1; currentLoop <= Constants.CONFIG.getLoop(); currentLoop++) {
            changeStateAndSendData(currentLoop);
            try {
                Thread.sleep(Constants.CONFIG.getSleepPerLoop() * 1000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    protected void sendMetrics()
    {
        for (final ProcessDetail process : hostDetail.getProcesses()) {
            output.flushData((JsonObject) Constants.GSON.toJsonTree(process));
        }
    }
    protected void sendHeartBeat() {
        System.out.println(Constants.YMAL.dump(hostDetail));
        output.flushData((JsonObject) Constants.GSON.toJsonTree(hostDetail));
    }
}
