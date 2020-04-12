package hcmus.advanced_db.log_generator;

import java.io.FileNotFoundException;

public class Generator {

    public static void main(final String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            throw new RuntimeException("Must have exactly two arguments");
        }
        final String hostName = args[0];
        final SystemStatus systemStatus = SystemStatus.fromString(args[1]);
        System.out.println(hostName);
        System.out.println(systemStatus);
        System.out.println(Utility.loadConfig());
    }
}
