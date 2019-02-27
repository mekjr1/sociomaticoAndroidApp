package ucm.ac.mz.sociomatico.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface RetrofitArrayApi {

    //@GET("wp-json/wp/v2/posts")
    //Call<List<WPPost>> getPostInfo();
    /// to make call to dynamic URL
     @GET
     Call<List<WPPost>> getPostInfo(@Url String url);

    // @GET
    // Call<List<Media>> getListCall(@Url String url);





}
