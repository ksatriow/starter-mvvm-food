package com.hellu.mvvmretrofit.model

import com.google.gson.annotations.SerializedName

data class FoodsResponse(
	@field:SerializedName("meals")
	val meals: List<MealsItem>? = null
)