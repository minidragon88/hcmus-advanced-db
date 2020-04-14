package hcmus.advanced_db.log_generator.runner.output;

import static hcmus.advanced_db.log_generator.Constants.LOGGER;

public class RestOutput implements IOutput
{
    @Override
    public void flushData(final String data)
    {
        LOGGER.info(data);
    }
}
