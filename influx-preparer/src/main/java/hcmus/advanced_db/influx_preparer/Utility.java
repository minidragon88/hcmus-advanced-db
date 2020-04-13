package hcmus.advanced_db.influx_preparer;

import com.google.common.io.Resources;

import hcmus.advanced_db.influx_preparer.model.Configuration;

import java.io.FileReader;
import java.io.IOException;

import static hcmus.advanced_db.influx_preparer.Constants.YAML;

public final class Utility
{
    private Utility() {}

    public static Configuration loadConfig()
    {
        try (FileReader reader = new FileReader(Resources.getResource("config.yml").getPath())) {
            return YAML.loadAs(new FileReader(Resources.getResource("config.yml").getPath()), Configuration.class);
        }
        catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
