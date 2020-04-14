package hcmus.advanced_db.log_generator.runner.output;

import hcmus.advanced_db.log_generator.Constants;
import hcmus.advanced_db.log_generator.Utility;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class RestOutput implements IOutput
{
    private final Retrofit retrofit = Utility.getRetrofitInstance(Constants.CONFIG.getServerUrl());
    private final WriteAPI api = retrofit.create(WriteAPI.class);

    @Override
    public void flushData(final String data)
    {
        final Call<String> call = api.writeData(Constants.CONFIG.getDatabaseName(), Constants.CONFIG.getUsername(), Constants.CONFIG.getPassword(), RequestBody.create(MediaType.parse("text/plain"), data));
        try {
            final Response<String> response = call.execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException(response.toString());
            }
        }
        catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
