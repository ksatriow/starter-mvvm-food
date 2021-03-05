package com.hellu.mvvmretrofit.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.hellu.mvvmretrofit.data.remote.ApiResponse
import com.hellu.mvvmretrofit.data.repository.FoodRepository
import com.hellu.mvvmretrofit.model.MealsItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val foodRepository = FoodRepository(application)
    private val _mealData = MutableLiveData<ApiResponse<List<MealsItem>>>()

    fun getMeal(): LiveData<ApiResponse<List<MealsItem>>> {
        return if (_mealData.value == null) return Transformations.map(foodRepository.getMeal()){
            _mealData.value = it
            it
        }
        else _mealData
    }

}