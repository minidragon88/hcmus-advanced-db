package hcmus.advanced_db.log_generator;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum OutputMode
{
    REST("rest");

    OutputMode(final String name)
    {
        this.name = name;
    }

    public static OutputMode fromString(final String name)
    {
        for (final OutputMode mode : OutputMode.values()) {
            if (mode.name.equals(name)) {
                return mode;
            }
        }
        throw new RuntimeException(String
                .format("Unknown output mode '%s'. Supported mode are %s",
                        name,
                        Arrays.asList(OutputMode.values())
                            .stream()
                            .map(mode -> mode.name)
                            .collect(Collectors.toList())));
    }
    private final String name;
}
