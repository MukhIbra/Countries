package com.example.countrylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countrylist.databinding.ActivityEditCountryBinding
import com.example.countrylist.modul.Country

class EditCountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityEditCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var country = intent.getSerializableExtra("country") as Country
        var index = intent.getIntExtra("index",0)

        binding.population.setText(country.population)
        binding.area.setText(country.area)

        binding.save.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("population",binding.population.text.toString())
            intent.putExtra("area",binding.area.text.toString())
            intent.putExtra("index",index)
            startActivity(intent)
            finish()
        }

    }
}