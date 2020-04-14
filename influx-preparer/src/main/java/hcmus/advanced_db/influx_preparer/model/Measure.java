package hcmus.advanced_db.influx_preparer.model;

import static hcmus.advanced_db.influx_preparer.Constants.YAML;

import java.util.List;
import java.util.Map;

public class Measure
{
    private String name;
    private List<String> tags;

    private Map<String, String> schema;
    private List<Map<String, Object>> data;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public List<String> getTags()
    {
        return tags;
    }

    public void setTags(final List<String> tags)
    {
        this.tags = tags;
    }

    public Map<String, String> getSchema()
    {
        return schema;
    }

    public void setSchema(final Map<String, String> schema)
    {
        this.schema = schema;
    }

    public List<Map<String, Object>> getData()
    {
        return data;
    }

    public void setData(final List<Map<String, Object>> data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return YAML.dump(this);
    }
}
