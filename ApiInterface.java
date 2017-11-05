package riaz.example.com.newzapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import riaz.example.com.newzapp.Objects.NewzDetailsObj;

/**
 * Created by RIAZ on 31/10/17.
 */

public interface ApiInterface {

    @GET("/v1/articles")
    Call<NewzDetailsObj> getNewzDetails(@Query("source") String source, @Query("sortBy") String sortBy,@Query("apiKey") String apiKey);


}
