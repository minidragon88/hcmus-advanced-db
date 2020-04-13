package hcmus.advanced_db.log_generator.runner.output;

import com.google.gson.JsonObject;

public interface IOutput {
    public void flushData(JsonObject data);
}
