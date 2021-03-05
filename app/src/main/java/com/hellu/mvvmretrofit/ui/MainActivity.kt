package com.hellu.mvvmretrofit.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellu.mvvmretrofit.R
import com.hellu.mvvmretrofit.data.remote.ApiResponse
import com.hellu.mvvmretrofit.util.ViewModelFactory
import com.hellu.mvvmretrofit.util.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mealsAdapter: MealAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = obtainViewModel()

        initFoodAdapter()
        getFoodData()
    }

    private fun getFoodData() {
        viewModel.getMeal().observe(this, Observer {
            when (it) {
                is ApiResponse.Success -> {
                    progressLayout.visibility = View.GONE
                    mealsAdapter.setData(it.data)
                }
                is ApiResponse.Error -> showToast(it.errorMessage)
                is ApiResponse.Loading -> progressLayout.visibility = View.VISIBLE
            }
        })
    }

    private fun initFoodAdapter() {
        mealsAdapter = MealAdapter()
        rvFoods.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mealsAdapter
        }
    }

    private fun obtainViewModel(): MainViewModel {
        return ViewModelFactory.getInstance(application).create(MainViewModel::class.java)
    }

}