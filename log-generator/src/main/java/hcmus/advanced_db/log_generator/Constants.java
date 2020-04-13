package hcmus.advanced_db.log_generator;

import java.text.DecimalFormat;

import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;

import hcmus.advanced_db.log_generator.model.Configuration;

public class Constants {
    private Constants() {}
    public static final Yaml YAML = new Yaml();
    public static final Gson GSON = new Gson();
    public static final Configuration CONFIG = Utility.loadConfig();
    public static final double MAX_NORMAL_VALUE = 500;
    public static final double MIN_NORMAL_VALUE = 0;
    public static final DecimalFormat ONE_POINT_DECIMAL_FORMAT = new DecimalFormat("####0.0");
}
