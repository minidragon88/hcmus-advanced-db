package hcmus.advanced_db.log_generator;

import java.io.FileReader;
import java.io.IOException;
import org.yaml.snakeyaml.Yaml;

import com.google.common.io.Resources;

import hcmus.advanced_db.log_generator.model.Configuration;

public final class Utility {
    public static final Yaml YAML = new Yaml();
    private Utility() {}
    
    public static Configuration loadConfig()
    {
        try(FileReader reader = new FileReader(Resources.getResource("config.yml").getPath())){
            return YAML.loadAs(new FileReader(Resources.getResource("config.yml").getPath()), Configuration.class);
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
