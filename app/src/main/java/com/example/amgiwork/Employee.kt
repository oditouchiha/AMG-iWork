package com.example.amgiwork

data class Employee(
    var name: String = "TEMPLATE",
    var eligibility: Int = 999,

    var pendingRequests: List<String> = listOf(""),
    var approvedRequests: List<String> = listOf(""),

    var photo: Int = 999
)

