package highjinro.high.search;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Kimmingyu on 2016. 10. 31..
 */

public interface network {
    @POST("/auth/reg")
    @FormUrlEncoded
    Call<Reg> Reg(@Field("id") String id, @Field("pw") String pw);

    @POST("/auth/info")
    @FormUrlEncoded
    Call<Info> Info(@Field("info") String info);
}
