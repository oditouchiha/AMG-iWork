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

        val quota = eligibility?.get("QUOTA")?.toString() ?: holder.tvQuota.text
        val quotaColor: Int = when {
            eligibility?.get("QUOTA") as? Int ?: 0 > 0 -> Color.parseColor("#006400")
            else -> Color.RED
        }

        val quotaText = SpannableString("Quota: $quota Day(s) until 15/10/2019")
        quotaText.setSpan(
            ForegroundColorSpan(quotaColor),
            6, 15,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        holder.tvQuota.text = quotaText
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_employee_name)
        var tvEligibility: TextView = itemView.findViewById(R.id.tv_item_employee_eligibility)
        var tvQuota: TextView = itemView.findViewById(R.id.tv_item_employee_quota)
        var imgPhoto: ImageView = itemView.findViewById(R.id.tv_item_employee_image)
    }
}