package hcmus.advanced_db.log_generator.runner;

import hcmus.advanced_db.log_generator.OutputMode;
import hcmus.advanced_db.log_generator.Utility;

public class OkSystemRunner extends AbstractRunner {

    public OkSystemRunner(final OutputMode outputMode) {
        super(outputMode);
    }

    @Override
    public void changeStateAndSendData(final int currentLoop) {
        Utility.updateNormalHost(hostDetail);
        logDetailInformation();
        sendMetrics();
        sendHeartBeat();
    }
}
