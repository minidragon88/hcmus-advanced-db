package hcmus.advanced_db.log_generator;

import com.google.common.io.Resources;

import hcmus.advanced_db.log_generator.model.Configuration;
import hcmus.advanced_db.log_generator.model.HostDetail;
import hcmus.advanced_db.log_generator.model.ProcessDetail;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static hcmus.advanced_db.log_generator.Constants.CONFIG;
import static hcmus.advanced_db.log_generator.Constants.MIN_NORMAL_VALUE;
import static hcmus.advanced_db.log_generator.Constants.ONE_POINT_DECIMAL_FORMAT;
import static hcmus.advanced_db.log_generator.Constants.YAML;

public final class Utility
{
    private Utility() {}

    private static final long TIME_OUT = 300L;

    public static Retrofit getRetrofitInstance(final String serverUrl)
    {
        final OkHttpClient okHttpClient  =
                new OkHttpClient()
                    .newBuilder()
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .build();
        return new Retrofit.Builder()
                .baseUrl(serverUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Configuration loadConfig()
    {
        try (FileReader reader = new FileReader(Resources.getResource("config.yml").getPath())) {
            return YAML.loadAs(new FileReader(Resources.getResource("config.yml").getPath()), Configuration.class);
        }
        catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getProcessOwner()
    {
        final List<String> owners = Arrays.asList("root", "user", "other");
        return owners.get(ThreadLocalRandom.current().nextInt(owners.size()));
    }

    public static double normalProcessValue()
    {
        final double value = ThreadLocalRandom.current().nextDouble(MIN_NORMAL_VALUE, Constants.MAX_NORMAL_VALUE) / 100;
        return Double.valueOf(ONE_POINT_DECIMAL_FORMAT.format(value));
    }

    public static double maciliousProcessValue(final int currentLoop, final int increasementalTime, final double remaining)
    {
        final double incrementalValue = (1d / increasementalTime) * 100;
        final double initial = normalProcessValue();
        return Math.min(initial + incrementalValue * currentLoop, remaining);
    }

    public static void updateMalaciousHost(final HostDetail hostDetail, final int currentLoop)
    {
        final int increasementalTime = CONFIG.getIncreasemental();
        ProcessDetail maliciousProcess = null;
        for (final ProcessDetail process : hostDetail.getProcesses()) {
            if (CONFIG.getMaciliousProcess().equals(process.getName())) {
                maliciousProcess = process;
            }
            else {
                process.setCpu(normalProcessValue());
                process.setMem(normalProcessValue());
            }
        }
        maliciousProcess.setCpu(0);
        maliciousProcess.setMem(0);
        maliciousProcess.setCpu(maciliousProcessValue(currentLoop, increasementalTime, 100 - hostDetail.getOverallCpu()));
        maliciousProcess.setMem(maciliousProcessValue(currentLoop, increasementalTime, 100 - hostDetail.getOverallMemory()));
    }

    public static void updateNormalHost(final HostDetail hostDetail)
    {
        for (final ProcessDetail process : hostDetail.getProcesses()) {
            process.setCpu(normalProcessValue());
            process.setMem(normalProcessValue());
        }
    }
}
