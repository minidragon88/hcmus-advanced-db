package hcmus.advanced_db.log_generator.runner;

import hcmus.advanced_db.log_generator.Constants;
import hcmus.advanced_db.log_generator.OutputMode;
import hcmus.advanced_db.log_generator.Utility;

public class ErrorSystemRunner extends AbstractRunner {

    public ErrorSystemRunner(final OutputMode outputMode) {
        super(outputMode);
    }

    @Override
    protected void changeStateAndSendData(final int currentLoop) {
        // Only flush data in case does not reach 100% utilization
        if (currentLoop <= Constants.CONFIG.getIncreasemental()) {
            Utility.updateMalaciousHost(hostDetail, currentLoop);
            sendMetrics();
            sendHeartBeat();
        }
    }
}
