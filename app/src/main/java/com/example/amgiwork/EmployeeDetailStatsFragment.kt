package com.example.amgiwork


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_employee_detail_stats.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class EmployeeDetailStatsFragment : Fragment(), EmployeeDetailActivity.OnAboutDataReceivedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mActivity = activity as EmployeeDetailActivity
        mActivity.setAboutDataListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_detail_stats, container, false)
    }

    override fun onDataReceived(employee: Employee) {
        tv_item_employee_name.text = employee.name
        Log.d("SASKEEEE", "SASUKE UCHIHA -> ${employee.name}")

        val du = DateUtils()
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        val nearestRequestDate = du.getNearestDate(du.stringsToDate(employee.pendingRequests))
        val nearestRequestDateFormatted =
            SimpleDateFormat("EEEE, yyyy-MM-dd", Locale.getDefault()).format(nearestRequestDate!!)

        tv_item_employee_nearestpendingrequest.text = nearestRequestDateFormatted

    }
}
