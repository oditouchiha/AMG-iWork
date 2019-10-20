package com.example.amgiwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_employee_detail.*


class EmployeeDetailActivity : AppCompatActivity() {
    private lateinit var mAboutDataListener: OnAboutDataReceivedListener
    private lateinit var employee: Employee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_detail)

        this.employee = intent.getParcelableExtra(EXTRA_EMPLOYEE)!!

        viewpager_employee_detail.adapter = MyPagerAdapter(supportFragmentManager)
        tablayout_employee_detail.setupWithViewPager(viewpager_employee_detail)

        mAboutDataListener.onDataReceived(this.employee)
    }

    fun setAboutDataListener(listener: OnAboutDataReceivedListener) {
        this.mAboutDataListener = listener
    }

    companion object {
        const val EXTRA_EMPLOYEE = "extra_employee"
    }

    interface OnAboutDataReceivedListener {
        fun onDataReceived(employee: Employee)
    }
}
