package com.example.amgiwork

object EmployeeData {

    private val employeeNames = listOf(
        "RINI",
        "WARIH",
        "HENY",
        "AZWANI",
        "ANTON",
        "DHIKA",
        "NODY",
        "ZOLA",
        "KENDY",
        "DIDIE"
    )

    private val employeeEligibilities = listOf(
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[1]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID"),
        Consts.ELIGIBILITY[2]?.get("ID")
    )

    private val employeeImages = listOf(
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible,
        R.drawable.semi_eligible
    )

    // =========================================================

    // PENDING REQUEST

    private val eligiblePendingRequests = listOf(
        "2019-10-02",
        "2019-10-04",
        "2019-10-07",
        "2019-10-11",
        "2019-10-14",
        "2019-10-18",
        "2019-10-21",
        "2019-10-25"
    )

    private val semiEligiblePendingRequests = listOf(
        "2019-10-01",
        "2019-10-14",
        "2019-10-28"
    )

    private val employeePendingRequests = listOf(
        eligiblePendingRequests,
        eligiblePendingRequests,
        eligiblePendingRequests,
        eligiblePendingRequests,
        semiEligiblePendingRequests,
        semiEligiblePendingRequests,
        semiEligiblePendingRequests,
        semiEligiblePendingRequests,
        semiEligiblePendingRequests,
        semiEligiblePendingRequests
    )

    // APPROVED REQUEST

    private val eligibleApprovedRequests = listOf(
        "2019-09-02",
        "2019-09-06",
        "2019-09-09",
        "2019-09-13",
        "2019-09-16",
        "2019-09-20",
        "2019-09-23",
        "2019-09-27"
    )

    private val semiEligibleApprovedRequests = listOf(
        "2019-09-02",
        "2019-09-16",
        "2019-09-30"
    )

    private val employeeApprovedRequests = listOf(
        eligibleApprovedRequests,
        eligibleApprovedRequests,
        eligibleApprovedRequests,
        eligibleApprovedRequests,
        semiEligibleApprovedRequests,
        semiEligibleApprovedRequests,
        semiEligibleApprovedRequests,
        semiEligibleApprovedRequests,
        semiEligibleApprovedRequests,
        semiEligibleApprovedRequests
    )

    // =============================================================

    val listData: ArrayList<Employee>
        get() {
            val list = arrayListOf<Employee>()
            for (position in employeeNames.indices) {
                val hero = Employee()
                hero.name = employeeNames[position]
                hero.eligibility = employeeEligibilities[position] as Int
                hero.photo = employeeImages[position]
                hero.pendingRequests = employeePendingRequests[position]
                hero.approvedRequests = employeeApprovedRequests[position]
                list.add(hero)
            }
            return list
        }
}