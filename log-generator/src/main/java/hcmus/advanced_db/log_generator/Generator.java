package hcmus.advanced_db.log_generator;

public class Generator {

    public static void main(final String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("Must have exactly two arguments");
        }
        final String hostName = args[0];
        final RunMode mode = RunMode.fromString(args[1]);
        System.out.println(hostName);
        System.out.println(mode);
    }
}
