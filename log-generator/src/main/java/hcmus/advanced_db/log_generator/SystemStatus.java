package hcmus.advanced_db.log_generator;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SystemStatus {
    OK("ok"),
    ERROR("error");

    SystemStatus(final String name)
    {
        this.name = name;
    }

    public static SystemStatus fromString(final String name)
    {
        for (final SystemStatus mode : SystemStatus.values()) {
            if (mode.name.equals(name)) {
                return mode;
            }
        }
        throw new RuntimeException(String
                .format("Unknown mode '%s'. Supported mode are %s",
                        name,
                        Arrays.asList(SystemStatus.values())
                            .stream()
                            .map(dataCenter -> dataCenter.name)
                            .collect(Collectors.toList())));
    }
    private final String name;
}
