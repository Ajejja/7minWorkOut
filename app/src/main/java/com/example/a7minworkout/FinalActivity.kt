package com.example.a7minworkout

import android.icu.text.SimpleDateFormat
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.a7minworkout.databinding.ActivityFinalBinding
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

class FinalActivity : AppCompatActivity() {
    private var binding:ActivityFinalBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolBarFinishActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolBarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.flFinish?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDataBase(dao)
    }

    private fun addDateToDataBase(historyDao:HistoryDao){
        val c=Calendar.getInstance()
        val dateTime=c.time
        Log.e("Date:",""+dateTime)
        val sdf=SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault() )
        val date =sdf.format(dateTime)
        Log.e("Formatted Date :",""+date)

        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date))
            Log.e(
                "Date : ",
                "Added..."
            )
        }
    }
}
