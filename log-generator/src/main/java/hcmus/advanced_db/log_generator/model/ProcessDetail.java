package hcmus.advanced_db.log_generator.model;

public class ProcessDetail
{
    private String host;
    private String name;
    private String owner;
    private double cpu;
    private double mem;

    public ProcessDetail(final String host, final String name, final String owner, final double cpu, final double mem)
    {
        this.host = host;
        this.name = name;
        this.owner = owner;
        this.cpu = cpu;
        this.mem = mem;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(final String host)
    {
        this.host = host;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(final String owner)
    {
        this.owner = owner;
    }

    public double getCpu()
    {
        return cpu;
    }

    public void setCpu(final double cpu)
    {
        this.cpu = cpu;
    }

    public double getMem()
    {
        return mem;
    }

    public void setMem(final double mem)
    {
        this.mem = mem;
    }

    @Override
    public String toString()
    {
        return String.format("host=%s, name=%s, owner=%s, cpu=%s, mem=%s", host, name, owner, cpu, mem);
    }

    public String toLineProtocol()
    {
        return String.format("metrics,host=%s process=\"%s\",owner=\"%s\",cpu=%s,memory=%s", host, name, owner, cpu, mem);
    }
}
