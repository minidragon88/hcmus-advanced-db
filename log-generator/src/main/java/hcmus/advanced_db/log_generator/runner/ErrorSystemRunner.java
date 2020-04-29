package hcmus.advanced_db.log_generator.runner;

import hcmus.advanced_db.log_generator.Constants;
import hcmus.advanced_db.log_generator.OutputMode;
import hcmus.advanced_db.log_generator.Utility;

import static hcmus.advanced_db.log_generator.Constants.LOGGER;

public class ErrorSystemRunner extends AbstractRunner
{
    public ErrorSystemRunner(final OutputMode outputMode)
    {
        super(outputMode);
    }

    @Override
    protected void changeStateAndSendData(final int currentLoop)
    {
        // Only flush data in case does not reach 100% utilization
        if (currentLoop <= Constants.CONFIG.getIncreasemental() || !Constants.CONFIG.isStopOnHang()) {
            Utility.updateMalaciousHost(hostDetail, currentLoop);
            logDetailInformation();
            sendMetrics();
            sendHeartBeat();
        }
        else {
            LOGGER.info("System hanged - no data to be sent");
        }
    }
}
