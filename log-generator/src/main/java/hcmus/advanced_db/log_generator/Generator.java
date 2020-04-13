package hcmus.advanced_db.log_generator;

import hcmus.advanced_db.log_generator.runner.AbstractRunner;
import hcmus.advanced_db.log_generator.runner.ErrorSystemRunner;
import hcmus.advanced_db.log_generator.runner.OkSystemRunner;

import java.io.FileNotFoundException;

public class Generator
{
    private Generator() {}
    public static void main(final String[] args) throws FileNotFoundException
    {
        if (args.length != 2) {
            throw new RuntimeException("Must have exactly two arguments");
        }
        final String hostName = args[0];
        final SystemStatus systemStatus = SystemStatus.fromString(args[1]);
        Constants.CONFIG.setHost(hostName);
        AbstractRunner runner = null;
        switch (systemStatus) {
        case OK:
            runner = new OkSystemRunner(OutputMode.REST);
            break;

        default:
            runner = new ErrorSystemRunner(OutputMode.REST);
            break;
        }
        runner.process();
    }
}
