package hcmus.advanced_db.log_generator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.google.common.io.Resources;

public final class Utility {
    private Utility() {}
    
    public static Map<String, String> loadConfig()
    {
        try(FileReader reader = new FileReader(Resources.getResource("config.yml").getPath())){
            return new Yaml().load(new FileReader(Resources.getResource("config.yml").getPath()));
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
