package com.cihangul.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Cihan on 26.06.2017.
 */

public interface Connect {
    @FormUrlEncoded
    @POST("kullanici.php")
    Call<List<Kullanici>> getKullanici(@Field("isim")String isim);

}
