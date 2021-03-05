package com.hellu.mvvmretrofit.data.remote

import com.hellu.mvvmretrofit.model.FoodsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("filter.php?c=Seafood")
    fun getFoods(): Call<FoodsResponse>
}