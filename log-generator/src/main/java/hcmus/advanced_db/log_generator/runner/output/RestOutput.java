package hcmus.advanced_db.log_generator.runner.output;

import java.util.List;

import com.google.gson.JsonObject;

public class RestOutput extends AbstractOutput {

    public RestOutput(final List<String> metadata) {
        super(metadata);
    }

    @Override
    public void flushData(final JsonObject data) {
        System.out.println("Flush data");
    }
}
