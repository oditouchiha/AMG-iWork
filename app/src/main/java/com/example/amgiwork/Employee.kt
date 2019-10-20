package com.example.amgiwork

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Employee(
    var name: String,
    var eligibility: Int,
    var pendingRequests: ArrayList<String>,
    var approvedRequests: ArrayList<String>,
    var photo: Int
) : Parcelable

