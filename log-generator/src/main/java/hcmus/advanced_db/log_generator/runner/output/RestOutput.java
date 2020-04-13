package hcmus.advanced_db.log_generator.runner.output;

import com.google.gson.JsonObject;

public class RestOutput implements IOutput {
    @Override
    public void flushData(final JsonObject data) {
        System.out.println("Flush data");
    }
}
