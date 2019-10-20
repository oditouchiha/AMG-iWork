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
import java.text.SimpleDateFormat
import java.util.*


class ListEmployeeAdapter(private val listEmployee: ArrayList<Employee>) :
    RecyclerView.Adapter<ListEmployeeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

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
        val employee = listEmployee[position]

        Glide.with(holder.itemView.context)
            .load(employee.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = employee.name

        val eligibility = Consts.ELIGIBILITY[employee.eligibility]
        holder.tvEligibility.text =
            eligibility?.get("TEXT")?.toString() ?: holder.tvEligibility.text

        val du = DateUtils()
        val nearestRequestDate = du.getNearestDate(du.stringsToDate(employee.pendingRequests))
        val nearestRequestDateFormatted =
            SimpleDateFormat("EEEE, yyyy-MM-dd", Locale.getDefault()).format(nearestRequestDate!!)
        val nearestRequestDateColor: Int = when {
            du.isDateInCurrentWeek(nearestRequestDate) -> Color.RED
            else -> Color.parseColor("#006400")
        }
        val nearestRequestDateText = "Nearest Request : \n$nearestRequestDateFormatted"
        val nearestRequestDateSpannedText = SpannableString(nearestRequestDateText)
        nearestRequestDateSpannedText.setSpan(
            ForegroundColorSpan(nearestRequestDateColor),
            17,
            nearestRequestDateText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        holder.tvNearestPendingRequest.text = nearestRequestDateSpannedText

        val pendingRequestAmountText = "Pending Requests : ${employee.pendingRequests.size}"
        holder.tvPendingRequestAmount.text = pendingRequestAmountText

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listEmployee[holder.adapterPosition])
        }
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

    interface OnItemClickCallback {
        fun onItemClicked(data: Employee)
    }
}