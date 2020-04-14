package hcmus.advanced_db.log_generator.model;

import java.util.List;

import static hcmus.advanced_db.log_generator.Constants.YAML;

public class Configuration
{
    private List<String> normalProcesses;
    private String maciliousProcess;
    private int loop = 5;
    private int increasemental = 5;
    private long sleepPerLoop = 5;
    private String host;
    private String serverUrl;
    private String username;
    private String password;
    private String databaseName;

    public List<String> getNormalProcesses()
    {
        return normalProcesses;
    }

    public void setNormalProcesses(final List<String> normalProcesses)
    {
        this.normalProcesses = normalProcesses;
    }

    public String getMaciliousProcess()
    {
        return maciliousProcess;
    }

    public void setMaciliousProcess(final String maciliousProcess)
    {
        this.maciliousProcess = maciliousProcess;
    }

    public int getLoop()
    {
        return loop;
    }

    public void setLoop(final int loop)
    {
        this.loop = loop;
    }

    public int getIncreasemental()
    {
        return increasemental;
    }

    public void setIncreasemental(final int increasemental)
    {
        this.increasemental = increasemental;
    }

    public long getSleepPerLoop()
    {
        return sleepPerLoop;
    }

    public void setSleepPerLoop(final long sleepPerLoop)
    {
        this.sleepPerLoop = sleepPerLoop;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(final String host)
    {
        this.host = host;
    }

    public String getServerUrl()
    {
        return serverUrl;
    }

    public void setServerUrl(final String serverUrl)
    {
        this.serverUrl = serverUrl;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public String getDatabaseName()
    {
        return databaseName;
    }

    public void setDatabaseName(final String databaseName)
    {
        this.databaseName = databaseName;
    }

    @Override
    public String toString()
    {
        return YAML.dump(this);
    }
}
