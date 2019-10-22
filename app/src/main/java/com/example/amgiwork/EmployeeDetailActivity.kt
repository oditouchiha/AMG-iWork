package com.example.amgiwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_employee_detail.*


class EmployeeDetailActivity : AppCompatActivity() {
    private var mListeners = ArrayList<DataUpdateListener>()
    private lateinit var employee: Employee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_detail)

        this.employee = intent.getParcelableExtra(EXTRA_EMPLOYEE)!!

        viewpager_employee_detail.adapter = MyPagerAdapter(supportFragmentManager)
        tablayout_employee_detail.setupWithViewPager(viewpager_employee_detail)

    }

    fun registerDataUpdateListener(listener: DataUpdateListener) {
        this.mListeners.add(listener)
    }

    fun unregisterDataUpdateListener(listener: DataUpdateListener) {
        this.mListeners.remove(listener)
    }

    @Synchronized
    fun dataUpdated() {
        for (listener in this.mListeners) {
            listener.onDataUpdate(this.employee)
        }
    }

    companion object {
        const val EXTRA_EMPLOYEE = "extra_employee"
    }

    interface DataUpdateListener {
        fun onDataUpdate(employee: Employee)
    }
}
