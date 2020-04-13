package hcmus.advanced_db.log_generator.runner.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

public class RestOutput implements IOutput {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestOutput.class);
    @Override
    public void flushData(final JsonObject data) {
        LOGGER.info("Flush data");
    }
}
