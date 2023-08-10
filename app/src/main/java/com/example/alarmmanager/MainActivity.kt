package com.example.alarmmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        binding.btnSetAlarm.setOnClickListener {
            alarmItem = AlarmItem(
                time = LocalDateTime.now().plusSeconds(binding.edtTime.text.toString().toLong()),
                binding.edtMsg.text.toString()
            )
            alarmItem?.let(scheduler::schedule)
            Toast.makeText(
                this,
                "alarm scheduled after ${binding.edtTime.text.toString()} : check Notification",
                Toast.LENGTH_LONG
            ).show()
        }

    }
}