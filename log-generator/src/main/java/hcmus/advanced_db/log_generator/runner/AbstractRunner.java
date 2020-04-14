package hcmus.advanced_db.log_generator.runner;

import hcmus.advanced_db.log_generator.Constants;
import hcmus.advanced_db.log_generator.OutputMode;
import hcmus.advanced_db.log_generator.model.HostDetail;
import hcmus.advanced_db.log_generator.model.ProcessDetail;
import hcmus.advanced_db.log_generator.runner.output.IOutput;
import hcmus.advanced_db.log_generator.runner.output.RestOutput;

import static hcmus.advanced_db.log_generator.Constants.LOGGER;

public abstract class AbstractRunner
{
    protected IOutput output;
    protected HostDetail hostDetail;

    public AbstractRunner(final OutputMode outputMode)
    {
        this.hostDetail = HostDetail.newHostDetail();
        switch (outputMode) {
        default:
            output = new RestOutput();
            break;
        }
    }

    protected abstract void changeStateAndSendData(int currentLoop);

    public void process()
    {
        // Send the initial values
        sendMetrics();
        sendHeartBeat();
        for (int currentLoop = 1; currentLoop <= Constants.CONFIG.getLoop(); currentLoop++) {
            changeStateAndSendData(currentLoop);
            try {
                LOGGER.info("Waiting for next time to send data");
                Thread.sleep(Constants.CONFIG.getSleepPerLoop() * 1000);
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void sendMetrics()
    {
        LOGGER.info("Sending metrics");
        for (final ProcessDetail process : hostDetail.getProcesses()) {
            output.flushData(process.toLineProtocol());
        }
    }

    protected void sendHeartBeat()
    {
        LOGGER.info("Sending heart beat");
        output.flushData(hostDetail.toLineProtocol());
    }

    protected void logDetailInformation()
    {
        LOGGER.info("Current host information");
        LOGGER.info(Constants.YAML.dump(hostDetail));
    }
}
