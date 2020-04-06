package hcmus.advanced_db.log_generator;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum RunMode {
    HEAlTHY("healthy"),
    UNHEALTHY("unhealthy");

    RunMode(final String name) {
        this.name = name;
    }

    public static RunMode fromString(final String name) {
        for (final RunMode mode : RunMode.values()) {
            if (mode.name.equals(name)) {
                return mode;
            }
        }
        throw new RuntimeException(String
                .format("Unknown mode '%s'. Supported mode are %s", 
                        name, 
                        Arrays.asList(RunMode.values())
                            .stream()
                            .map(dataCenter -> dataCenter.name)
                            .collect(Collectors.toList())));
    }
    private final String name;
}
