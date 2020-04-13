package hcmus.advanced_db.log_generator.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hcmus.advanced_db.log_generator.Constants;
import hcmus.advanced_db.log_generator.OutputMode;
import hcmus.advanced_db.log_generator.Utility;

public class ErrorSystemRunner extends AbstractRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorSystemRunner.class);
    public ErrorSystemRunner(final OutputMode outputMode) {
        super(outputMode);
    }

    @Override
    protected void changeStateAndSendData(final int currentLoop) {
        // Only flush data in case does not reach 100% utilization
        if (currentLoop <= Constants.CONFIG.getIncreasemental()) {
            Utility.updateMalaciousHost(hostDetail, currentLoop);
            logDetailInformation();
            sendMetrics();
            sendHeartBeat();
        } else {
            LOGGER.info("System hanged - no data to be sent");
        }
    }
}
