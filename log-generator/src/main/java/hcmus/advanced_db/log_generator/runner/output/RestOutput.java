package hcmus.advanced_db.log_generator.runner.output;

import com.google.gson.JsonObject;

import static hcmus.advanced_db.log_generator.Constants.LOGGER;

public class RestOutput implements IOutput
{
    @Override
    public void flushData(final JsonObject data)
    {
        LOGGER.info("Flush data");
    }
}
