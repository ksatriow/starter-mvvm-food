package com.hellu.mvvmretrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hellu.mvvmretrofit.R
import com.hellu.mvvmretrofit.model.MealsItem
import com.hellu.mvvmretrofit.util.show
import kotlinx.android.synthetic.main.item_foods.view.*

class MealAdapter : RecyclerView.Adapter<MealAdapter.Holder>() {

    private var meals : ArrayList<MealsItem> = arrayListOf()

    fun setData(meals: List<MealsItem>){
        this.meals.clear()
        this.meals.addAll(meals)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_foods, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val meal = meals[position]
        holder.bind(meal)
    }

    override fun getItemCount(): Int = meals.size

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(meals: MealsItem){
            with(itemView){
                tvIdFoods.text = meals.idMeal
                tvNameFoods.text = meals.strMeal
                ivImageFoods.show(meals.strMealThumb)
            }
        }
    }

}
