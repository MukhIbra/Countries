package com.example.countrylist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.graphics.drawable.toDrawable
import coil.load
import coil.transform.CircleCropTransformation
import com.example.countrylist.databinding.ActivityMainBinding
import com.example.countrylist.databinding.ItemCountryBinding
import com.example.countrylist.modul.Country

class CountryAdapter(context: Context, var countries: MutableList<Country>, var binding2:ActivityMainBinding) :
    ArrayAdapter<Country>(context, R.layout.item_country, countries) {
    override fun getCount(): Int {
        return countries.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: ItemCountryBinding
        if (convertView == null) {
            binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }else{
            binding= ItemCountryBinding.bind(convertView)
        }
        val user = countries.get(position)
        binding.img.load(user.img){
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
            transformations(CircleCropTransformation())
        }
        binding.name.text = user.name
        binding.population.text = user.population
        binding.area.text = user.area
        if (countries.get(position).status) binding.favourite.setImageResource(R.drawable.ic_baseline_favorite_24)
        else binding.favourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)

        binding.favourite.setOnClickListener{
            if (countries.get(position).status){
                binding.favourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                countries.get(position).status = false
                if (binding2.favourite.tag == 1){
                    countries.removeAt(position)
                    notifyDataSetChanged()
                }
                return@setOnClickListener
            }
            binding.favourite.setImageResource(R.drawable.ic_baseline_favorite_24)
            countries.get(position).status = true
        }
        binding.delete.setOnClickListener {
            countries.removeAt(position)
            notifyDataSetChanged()
        }
        binding.edit.setOnClickListener {
            val intent = Intent(parent.context,EditCountryActivity::class.java)
            intent.putExtra("country",user)
            intent.putExtra("index",position)
            parent.context.startActivity(intent)
        }
        return binding.root
    }
}