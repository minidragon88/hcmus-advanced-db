package hcmus.advanced_db.log_generator.runner.output;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WriteAPI
{
    @POST("write")
    Call<String> writeData(@Query("db") String database, @Query("u") String username, @Query("p") String password, @Body RequestBody body);
}
