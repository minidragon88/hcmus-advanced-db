package hcmus.advanced_db.influx_preparer.model;

import java.util.List;

import static hcmus.advanced_db.influx_preparer.Constants.YAML;

public class Configuration
{
    private String serverUrl;
    private String username;
    private String password;
    private String databaseName;
    private List<Serie> series;
    private boolean dropOldSeries;
    private List<String> continuousQueries;

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

    public List<Serie> getSeries()
    {
        return series;
    }

    public void setSeries(final List<Serie> series)
    {
        this.series = series;
    }

    public boolean isDropOldSeries()
    {
        return dropOldSeries;
    }

    public void setDropOldSeries(final boolean dropOldSeries)
    {
        this.dropOldSeries = dropOldSeries;
    }

    public List<String> getContinuousQueries()
    {
        return continuousQueries;
    }

    public void setContinuousQueries(final List<String> continuousQueries)
    {
        this.continuousQueries = continuousQueries;
    }

    @Override
    public String toString()
    {
        return YAML.dump(this);
    }
}
