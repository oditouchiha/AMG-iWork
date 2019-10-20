package com.example.amgiwork

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs


class ListEmployeeAdapter(private val listEmployee: ArrayList<Employee>) :
    RecyclerView.Adapter<ListEmployeeAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {

        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_employee, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listEmployee.size
    }

    @Suppress("FunctionName")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        fun _isDateInCurrentWeek(date: Date): Boolean {
            val currentCalendar = Calendar.getInstance()
            val week = currentCalendar.get(Calendar.WEEK_OF_YEAR)
            val year = currentCalendar.get(Calendar.YEAR)

            val targetCalendar = Calendar.getInstance()
            targetCalendar.time = date
            val targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR)
            val targetYear = targetCalendar.get(Calendar.YEAR)

            return week == targetWeek && year == targetYear
        }

        fun _getNearestDate(dates: List<Date>): Date? {
            val currentCalendar = Calendar.getInstance()
            currentCalendar.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH) + 1)
            val currentmillis = currentCalendar.timeInMillis

            return Collections.min(dates) { d1, d2 ->
                val diff1 = abs(d1.time - currentmillis)
                val diff2 = abs(d2.time - currentmillis)

                diff1.compareTo(diff2)
            }
        }

        fun _stringsToDate(strdates: List<String>): MutableList<Date> {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dates = mutableListOf<Date>()
            for (strdate in strdates) {
                try {
                    dates.add(format.parse(strdate)!!)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
            return dates
        }

        val employee = listEmployee[position]

        Glide.with(holder.itemView.context)
            .load(employee.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = employee.name

        val eligibility = Consts.ELIGIBILITY[employee.eligibility]
        holder.tvEligibility.text =
            eligibility?.get("TEXT")?.toString() ?: holder.tvEligibility.text

        val nearestRequestDate = _getNearestDate(_stringsToDate(employee.pendingRequests))
        val nearestRequestDateFormatted =
            SimpleDateFormat("EEEE, yyyy-MM-dd", Locale.getDefault()).format(nearestRequestDate!!)
        val nearestRequestDateColor: Int = when {
            _isDateInCurrentWeek(nearestRequestDate) -> Color.RED
            else -> Color.parseColor("#006400")
        }
        val nearestRequestDateText = "Nearest Request : \n$nearestRequestDateFormatted"
        val nearestRequestDateSpannedText = SpannableString(nearestRequestDateText)
        nearestRequestDateSpannedText.setSpan(
            ForegroundColorSpan(nearestRequestDateColor),
            16,
            nearestRequestDateText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        holder.tvNearestPendingRequest.text = nearestRequestDateSpannedText

        val pendingRequestAmountText = "Pending Requests : ${employee.pendingRequests.size}"
        holder.tvPendingRequestAmount.text = pendingRequestAmountText
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_employee_name)
        var tvEligibility: TextView = itemView.findViewById(R.id.tv_item_employee_eligibility)
        var tvNearestPendingRequest: TextView =
            itemView.findViewById(R.id.tv_item_employee_nearestpendingrequest)
        var tvPendingRequestAmount: TextView =
            itemView.findViewById(R.id.tv_item_employee_pendingrequestamount)
        var imgPhoto: ImageView = itemView.findViewById(R.id.tv_item_employee_image)
    }
}