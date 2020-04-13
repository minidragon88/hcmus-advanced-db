package hcmus.advanced_db.influx_preparer.model;

import static hcmus.advanced_db.influx_preparer.Constants.YAML;

public class Serie
{
    private String name;
    private String data;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getData()
    {
        return data;
    }

    public void setData(final String data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return YAML.dump(this);
    }
}
