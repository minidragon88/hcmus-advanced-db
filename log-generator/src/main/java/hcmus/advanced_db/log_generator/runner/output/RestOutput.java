package hcmus.advanced_db.log_generator.runner.output;

import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestOutput implements IOutput
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RestOutput.class);

    @Override
    public void flushData(final JsonObject data)
    {
        LOGGER.info("Flush data");
    }
}
