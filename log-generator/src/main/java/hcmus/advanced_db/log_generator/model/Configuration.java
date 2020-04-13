package hcmus.advanced_db.log_generator.model;

import static hcmus.advanced_db.log_generator.Utility.YAML;

import java.util.List;

public class Configuration {
    public List<String> normal_processes;
    public List<String> macilious_processes;
    public int loopTime = 5;
    public long sleepTimePerLoop = 5;
    @Override
    public String toString() {
        return YAML.dump(this);
    }
}
