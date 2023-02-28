package com.example.countrylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.countrylist.databinding.ActivityMoreInfoBinding
import com.example.countrylist.modul.Country

class MoreInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var country: Country = intent.getSerializableExtra("user") as Country
        binding.img.load(country.img) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images.load(country.images) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images2.load(country.images2) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.images3.load(country.images3) {
            placeholder(R.drawable.ic_launcher_background)
            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
        }
        binding.name.text = country.name
        binding.population.text = country.population
        binding.area.text = country.area

    }
}