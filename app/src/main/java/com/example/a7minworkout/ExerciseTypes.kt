package com.example.a7minworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7minworkout.databinding.ActivityExerciseTypesBinding

class ExerciseTypes : AppCompatActivity() {
    private  var binding: ActivityExerciseTypesBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseTypesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarBmiActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Exercises Lists"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }


        binding?.legCardView?.setOnClickListener {
            val intent = Intent(this, LegActivity::class.java)
            startActivity(intent)

        }
        binding?.absCardView?.setOnClickListener {
            val intent = Intent(this, AbsActivity::class.java)
            startActivity(intent)

        }
        binding?.chestCardView?.setOnClickListener {
            val intent = Intent(this, ChestActivity::class.java)
            startActivity(intent)

        }
        binding?.bicepsCardView?.setOnClickListener {
            val intent = Intent(this, BicepsActivity::class.java)
            startActivity(intent)

        }
        binding?.tricepsCardView?.setOnClickListener {
            val intent = Intent(this, TricepsActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
