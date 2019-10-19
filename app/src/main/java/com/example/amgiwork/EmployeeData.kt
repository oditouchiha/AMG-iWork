package com.example.amgiwork

object EmployeeData {

    private val employeeNames = arrayOf(
        "RINI",
        "WARIH",
        "HENY",
        "NODY",
        "ZOLA",
        "KENDY",
        "DIDIE",
        "DITO",
        "FIKRY",
        "IKA"
    )

    private val employeeEligibilities = arrayOf(
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[3]?.get("ID"),
        Consts.ELIGIBILITY[3]?.get("ID"),
        Consts.ELIGIBILITY[3]?.get("ID")
    )

    private val employeeImages = intArrayOf(
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.non_eligible,
        R.drawable.non_eligible,
        R.drawable.non_eligible
    )

    private val employeePendingRequestAmount = intArrayOf(
        6, 2, 5, 2, 1, 6, 2, 9, 59, 11
    )

    private val employeeNearestPendingRequestDate = arrayOf(
        "2109-10-02",
        "2109-10-06",
        "2109-10-11",
        "2109-10-18",
        "2109-10-23",
        "2109-10-29",
        "2109-10-15",
        "2109-10-09",
        "2109-10-13",
        "2109-10-02"
    )

    val listData: ArrayList<Employee>
        get() {
            val list = arrayListOf<Employee>()
            for (position in employeeNames.indices) {
                val hero = Employee()
                hero.name = employeeNames[position]
                hero.eligibility = employeeEligibilities[position] as Int
                hero.photo = employeeImages[position]
                hero.pendingRequestAmount = employeePendingRequestAmount[position]
                hero.nearestPendingRequest = employeeNearestPendingRequestDate[position]
                list.add(hero)
            }
            return list
        }
}