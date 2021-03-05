package com.hellu.mvvmretrofit.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellu.mvvmretrofit.data.remote.ApiResponse
import com.hellu.mvvmretrofit.data.remote.RemoteDataSource
import com.hellu.mvvmretrofit.model.FoodsResponse
import com.hellu.mvvmretrofit.model.MealsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository(application: Application) {

    fun getMeal(): LiveData<ApiResponse<List<MealsItem>>> {
        val data = MutableLiveData<ApiResponse<List<MealsItem>>>()

        data.value = ApiResponse.Loading
        RemoteDataSource().callApi().getFoods().enqueue(object: Callback<FoodsResponse> {
            override fun onResponse(call: Call<FoodsResponse>, response: Response<FoodsResponse>) {
                if (response.isSuccessful){
                    response.body()?.meals?.let {
                        data.value = ApiResponse.Success(it)
                    }
                }else{
                    data.value = ApiResponse.Error(response.message())
                }
            }

            override fun onFailure(call: Call<FoodsResponse>, t: Throwable) {
                data.value = ApiResponse.Error(t.message.toString())
            }

        })
        return data
    }


}