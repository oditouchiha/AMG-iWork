package com.example.amgiwork


import android.app.Activity
import android.os.Bundle
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
class EmployeeDetailStatsFragment : Fragment(), EmployeeDetailActivity.DataUpdateListener {

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        (activity as EmployeeDetailActivity).registerDataUpdateListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mActivity = activity as EmployeeDetailActivity
        mActivity.registerDataUpdateListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_detail_stats, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as EmployeeDetailActivity).dataUpdated()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as EmployeeDetailActivity).unregisterDataUpdateListener(this)
    }

    override fun onDataUpdate(employee: Employee) {
        tv_item_employee_name_ed.text = employee.name

        val du = DateUtils()
        val nearestRequestDate = du.getNearestDate(du.stringsToDate(employee.pendingRequests))
        val nearestRequestDateFormatted =
            SimpleDateFormat("EEEE, yyyy-MM-dd", Locale.getDefault()).format(nearestRequestDate!!)

        tv_item_employee_nearestpendingrequest_ed.text = nearestRequestDateFormatted

    }
}
