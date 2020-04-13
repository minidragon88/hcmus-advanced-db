package hcmus.advanced_db.log_generator.model;

import static hcmus.advanced_db.log_generator.Constants.YAML;
import java.util.List;

public class Configuration {
    private List<String> normal_processes;
    private String macilious_process;
    private int loop = 5;
    private int increasemental = 5;
    private long sleepPerLoop = 5;
    private String host;
    
    public List<String> getNormal_processes() {
        return normal_processes;
    }

    public void setNormal_processes(final List<String> normal_processes) {
        this.normal_processes = normal_processes;
    }

    public String getMacilious_process() {
        return macilious_process;
    }

    public void setMacilious_process(final String macilious_process) {
        this.macilious_process = macilious_process;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(final int loop) {
        this.loop = loop;
    }

    public int getIncreasemental() {
        return increasemental;
    }

    public void setIncreasemental(final int increasemental) {
        this.increasemental = increasemental;
    }

    public long getSleepPerLoop() {
        return sleepPerLoop;
    }

    public void setSleepPerLoop(final long sleepPerLoop) {
        this.sleepPerLoop = sleepPerLoop;
    }

    public String getHost() {
        return host;
    }
    
    public void setHost(final String host)
    {
        this.host = host;
    }

    @Override
    public String toString() {
        return YAML.dump(this);
    }
}
