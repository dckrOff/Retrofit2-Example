package com.a1tech.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NoticeData {

    @GET("main.do?mode=take_orders")
    Call<GetDataModel> request(@Query("driver_id") int  driverId,
                               @Query("lat") double lat,
                               @Query("lon") double lon);
}
