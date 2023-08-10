package com.example.alarmmanager

interface AlarmSceduler {
    fun schedule(item: AlarmItem)
    fun cancel(item: AlarmItem)
}