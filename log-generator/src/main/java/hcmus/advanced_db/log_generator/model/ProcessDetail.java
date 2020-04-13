package hcmus.advanced_db.log_generator.model;

public class ProcessDetail {
    private final String host;
    private final String name;
    private final String owner;
    private final double cpu;
    private final double mem;
    
    public ProcessDetail(final String host, final String name, final String owner, final double cpu, final double mem) {
        this.host = host;
        this.name = name;
        this.owner = owner;
        this.cpu = cpu;
        this.mem = mem;
    }
    
    public String getHost() {
        return host;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public double getCpu() {
        return cpu;
    }

    public double getMem() {
        return mem;
    }
    
    @Override
    public String toString() {
        return String.format("host=%s, name=%s, owner=%s, cpu=%s, mem=%s", host, name, owner, cpu, mem);
    }
}
