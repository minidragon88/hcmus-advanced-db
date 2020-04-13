package hcmus.advanced_db.influx_preparer;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class Constants
{
    private Constants() {}
    public static final Logger LOGGER = LoggerFactory.getLogger("default");
    public static final Yaml YAML = new Yaml();
    public static final Gson GSON = new Gson();
}
