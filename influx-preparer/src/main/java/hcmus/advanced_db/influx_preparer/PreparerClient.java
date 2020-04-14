package hcmus.advanced_db.influx_preparer;

import hcmus.advanced_db.influx_preparer.model.Configuration;
import hcmus.advanced_db.influx_preparer.model.Measure;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Point.Builder;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PreparerClient implements AutoCloseable
{
    private final InfluxDB db = getDBClient();

    public static InfluxDB getDBClient()
    {
        return getDBClient(Utility.loadConfig());
    }

    public static InfluxDB getDBClient(final Configuration config)
    {
        return InfluxDBFactory.connect(config.getServerUrl(), config.getUsername(), config.getPassword());
    }

    public void setDefaultDatabase(final String database)
    {
        db.setDatabase(database);
    }

    public QueryResult executeQuery(final String query)
    {
        try {
            final QueryResult results = db.query(new Query(query));
            if (results.getError() != null) {
                Constants.LOGGER.error(results.getError());
                throw new RuntimeException(results.getError());
            }
            return results;
        }
        catch (final Exception e) {
            Constants.LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<String> getDatabases()
    {
        Constants.LOGGER.info("Getting databases");
        final List<String> databases = new ArrayList<>();
        final String query = "SHOW DATABASES";
        final QueryResult results = executeQuery(query);
        for (final List<Object> values : results.getResults().get(0).getSeries().get(0).getValues()) {
            databases.add((String) values.get(0));
        }
        return databases;
    }

    public boolean isDatabaseExisted(final String database)
    {
        return getDatabases().contains(database);
    }

    public void createDatabase(final String database)
    {
        Constants.LOGGER.info("Creating databases");
        final String query = String.format("CREATE DATABASE %s", database);
        executeQuery(query);
    }

    public void dropMeasure(final String name)
    {
        Constants.LOGGER.info("Dropping measurement");
        final String query = String.format("DROP MEASUREMENT %s", name);
        executeQuery(query);
    }

    public void deleteMeasure(final String name)
    {
        Constants.LOGGER.info("Deleting measurement");
        final String query = String.format("DELETE FROM %s", name);
        executeQuery(query);
    }

    public void insertData(final Measure measure)
    {
        Constants.LOGGER.info("Inserting data");
        for (final Map<String, Object> dataPoint : measure.getData()) {
            db.write(createPoint(measure.getName(), measure.getTags(), measure.getSchema(), dataPoint));
        }
    }

    private Point createPoint(final String measureName, final List<String> tags, final Map<String, String> schema, final Map<String, Object> dataPoint)
    {
        final Builder builder = Point.measurement(measureName);
        for (final String key : schema.keySet()) {
            switch (schema.get(key)) {
            case "string":
                final String stringValue = (String) dataPoint.get(key);
                if (tags.contains(key)) {
                    builder.tag(key, stringValue);
                }
                else {
                    builder.addField(key, stringValue);
                }
                break;
            default:
                final double doubleValue = Double.valueOf(dataPoint.get(key).toString());
                builder.addField(key, doubleValue);
                break;
            }
        }
        return builder.build();
    }

    @Override
    public void close()
    {
        db.close();
    }
}
