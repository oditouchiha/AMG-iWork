package com.example.amgiwork


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
        fragment_employeedetailstats_tv_employee_image.setImageDrawable(context?.let {
            ContextCompat.getDrawable(
                it, employee.photo
            )
        })

        fragment_employeedetailstats_tv_employee_name.text = employee.name

        val eligibility = Consts.ELIGIBILITY[employee.eligibility]
        fragment_employeedetailstats_tv_employee_eligibility.text =
            eligibility?.get("TEXT")?.toString()
                ?: fragment_employeedetailstats_tv_employee_eligibility.text

        val du = DateUtils()
        val nearestRequestDate = du.getNearestDate(du.stringsToDate(employee.pendingRequests))
        val nearestRequestDateFormatted =
            SimpleDateFormat("EEEE, yyyy-MM-dd", Locale.getDefault()).format(nearestRequestDate!!)
        val nearestRequestDateText = "Nearest Request : $nearestRequestDateFormatted"
        fragment_employeedetailstats_tv_employee_nearestpendingrequest.text = nearestRequestDateText

        val pendingRequestsAmount = employee.pendingRequests.size
        val pendingRequestsAmountText = "Pending Requests : $pendingRequestsAmount"
        fragment_employeedetailstats_tv_employee_pendingrequests.text = pendingRequestsAmountText

        val approvedRequestsAmount = employee.approvedRequests.size
        val approvedRequestsAmountText = "Approved Requests : $approvedRequestsAmount"
        fragment_employeedetailstats_tv_employee_approvedrequests.text = approvedRequestsAmountText
    }
}
