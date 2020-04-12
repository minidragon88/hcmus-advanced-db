package hcmus.advanced_db.log_generator.runner.output;

import java.util.List;

import com.google.gson.JsonObject;

public abstract class AbstractOutput {
    protected final List<String> metadata;
    public AbstractOutput(final List<String> metadata) {
        this.metadata = metadata;
    }
    public abstract void flushData(JsonObject data);
}
