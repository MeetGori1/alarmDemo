package com.example.alarmmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarmmanager.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val scheduler = AndroidAlarmScheduler(this)
        var alarmItem: AlarmItem? = null


        alarmItem = AlarmItem(
            time = LocalDateTime.now().plusSeconds(20),
            "alarm messege : Good Morning water"
        )

        binding.txtSetAlarm.setOnClickListener {
            alarmItem.let(scheduler::schedule)
        }

    }
}