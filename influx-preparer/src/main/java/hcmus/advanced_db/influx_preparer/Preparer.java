package hcmus.advanced_db.influx_preparer;

import hcmus.advanced_db.influx_preparer.model.Configuration;
import hcmus.advanced_db.influx_preparer.model.Measure;

import java.io.FileNotFoundException;

public class Preparer
{
    private Preparer() {}
    public static void main(final String[] args) throws FileNotFoundException
    {
        final Configuration config = Utility.loadConfig();
        final String database = config.getDatabaseName();
        try (PreparerClient client = new PreparerClient()) {
            // Create database
            final boolean isDatabaseExisted = client.isDatabaseExisted(database);
            if (!isDatabaseExisted) {
                client.createDatabase(database);
            }
            client.setDefaultDatabase(database);
            // Create measures
            final String measureAction = config.getMeasureAction();
            if (measureAction.equalsIgnoreCase("DROP")) {
                for (final Measure measure : config.getMeasures()) {
                    client.dropMeasure(measure.getName());
                }
            }
            else if (measureAction.equalsIgnoreCase("DELETE")) {
                for (final Measure measure : config.getMeasures()) {
                    client.deleteMeasure(measure.getName());
                }
            }
            // Insert measure data
            for (final Measure measure : config.getMeasures()) {
                client.insertData(measure);
            }
        }
    }
}
